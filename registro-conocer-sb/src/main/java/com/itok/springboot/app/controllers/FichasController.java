package com.itok.springboot.app.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.itok.springboot.app.models.entity.EvaluadorIndependiente;
import com.itok.springboot.app.models.entity.FichaRegistro;
import com.itok.springboot.app.models.service.ICandidatoService;
import com.itok.springboot.app.models.service.IEstandarService;
import com.itok.springboot.app.models.service.IEvaluadorIndependienteService;
import com.itok.springboot.app.models.service.IUploadFileService;
import com.itok.springboot.app.models.service.IFichaRegistroService;
@Secured({"ROLE_EDITOR","ROLE_ADMIN"})
@Controller
@SessionAttributes("fichaRegistro")
@RequestMapping("/operaciones")
public class FichasController {

	@Autowired
	private IEvaluadorIndependienteService eiservice;
	@Autowired
	private IEstandarService estandarService;
	@Autowired
	private IFichaRegistroService fichaRegistroService;
	@Autowired
	private ICandidatoService candidatoService;
	@Autowired
	private IUploadFileService uploadFileService;

	
	@GetMapping("/fichaRegistro")
	public String fichaRegistro(Model model) {
		System.out.println("entrando al controller registro de ficha");

		FichaRegistro fichaRegistro = new FichaRegistro();
		model.addAttribute("titulo", "Registro de fichas por administrador");
		model.addAttribute("listaEI", eiservice.findAll());
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("fichaRegistro", fichaRegistro);
		return "operaciones/fichas/ficha";
	}

	@PostMapping(value = "/registraFicha")
	public String guardar(@Valid FichaRegistro fichaRegistro, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Registro de fichas por administrador");
			model.addAttribute("listaEI", eiservice.findAll());
			model.addAttribute("listaEstandar", estandarService.findAll());
			return "operaciones/fichas/ficha";
		}

		if (!foto.isEmpty()) {

			// si es edición de foto
			if (fichaRegistro.getCandidato().getIdCandidato() > 0
					&& fichaRegistro.getCandidato().getImageReference() != null
					&& fichaRegistro.getCandidato().getImageReference().length() > 0) {
				uploadFileService.delete(fichaRegistro.getCandidato().getImageReference());
			}

			String uniqueFilename = null;
			try {
				uniqueFilename = uploadFileService.copy(foto);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			model.addAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
			fichaRegistro.getCandidato().setImageReference(uniqueFilename);

		}

		String mensajeFlash = (fichaRegistro.getCandidato().getIdCandidato() != 0) ? "Candidato editado con éxito"
				: "Candidato creado con éxito";

		// Persistir al candidato
		int i = candidatoService.saveGetId(fichaRegistro.getCandidato());

		// asignando id de candidato persistido
		fichaRegistro.getCandidato().setIdCandidato(i);
		System.out.println("id de persistencia recibido: " + i);

		// Persistir la ficha
		fichaRegistroService.save(fichaRegistro);
		model.addAttribute("warning",
				"Se ha cargado correctamente la ficha '" + fichaRegistro.getIdFichaRegistro() + "'");
		status.setComplete(); // eliminar el fichaRegistro de la sesión
		model.addAttribute("success", mensajeFlash);
		model.addAttribute("titulo", "Carga exitosa");
		return "operaciones/fichas/success";
	}

	@GetMapping(value="/fichaRegistro/{id}")
	public String editar(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {

		FichaRegistro fichaRegistro = null;
		if (id > 0) {
			fichaRegistro = fichaRegistroService.findOne(id);
			if (fichaRegistro == null) {
				flash.addFlashAttribute("error", "El ID de la ficha no existe en la BBDD!");
				return "redirect:/inicio";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la ficha no puede ser cero!");
			return "redirect:/inicio";
		}
		model.addAttribute("titulo", "Editar ficha");
		model.addAttribute("listaEI", eiservice.findAll());
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("fichaRegistro", fichaRegistro);
		return "operaciones/fichas/ficha";
	}

	@GetMapping(value="/imprimir/{id}")
	public String imprimr(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {

		FichaRegistro fichaRegistro = null;
		if (id > 0) {
			fichaRegistro = fichaRegistroService.findOne(id);
			if (fichaRegistro == null) {
				flash.addFlashAttribute("error", "El ID de la ficha no existe en la BBDD!");
				return "redirect:/inicio";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la ficha no puede ser cero!");
			return "redirect:/inicio";
		}
		model.addAttribute("titulo", "Editar ficha");
		model.addAttribute("listaEI", eiservice.findAll());
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("fichaRegistro", fichaRegistro);
		return "operaciones/fichas/imprimir";
	}

	
	
	@GetMapping(value = "/cargar-evaluadores/{term}", produces = { "application/json" })
	public @ResponseBody List<EvaluadorIndependiente> cargarEvaluadores(@PathVariable String term) {
		return eiservice.findByNombre(term);
	}

}
