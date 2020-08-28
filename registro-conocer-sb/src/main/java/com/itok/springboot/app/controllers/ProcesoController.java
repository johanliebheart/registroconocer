package com.itok.springboot.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.itok.springboot.app.models.entity.FichaRegistro;
import com.itok.springboot.app.models.entity.LoteDictamen;
import com.itok.springboot.app.models.entity.Proceso;
import com.itok.springboot.app.models.service.IFichaRegistroService;
import com.itok.springboot.app.models.service.ILoteDictamenService;
import com.itok.springboot.app.models.service.IProcesoService;

@Controller
@RequestMapping("/procesos")
@SessionAttributes("proceso")
public class ProcesoController {

	@Autowired
	private IProcesoService procesoService;
	@Autowired
	private IFichaRegistroService fichaRegistroService;
	@Autowired
	private ILoteDictamenService loteDictamenService;

	@GetMapping(value = "/procesos")
	public String procesos(Model model) {
		model.addAttribute("listaProcesos", procesoService.findAll());
		model.addAttribute("listaFichas", fichaRegistroService.findByActivo());
		model.addAttribute("titulo", "Procesos");
		return "procesos/procesos";
	}

	@GetMapping(value = "/procesos/{id}")
	public String iniciar(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {
		FichaRegistro fichaRegistro = null;
		if (id > 0) {
			fichaRegistro = fichaRegistroService.findOne(id);
			if (fichaRegistro == null) {
				flash.addFlashAttribute("error", "El ID de la ficha no existe en la BBDD!");
				return "redirect:/procesos/procesos";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la ficha no puede ser cero!");
			return "redirect:/procesos/procesos";
		}
		Proceso proceso = new Proceso();
		LoteDictamen loteDictamen = new LoteDictamen();
		loteDictamen.setIdLoteDictamen(0);
		proceso.setIdLoteDictamen(loteDictamen);
		proceso.setIdFichaRegistro(fichaRegistro);
		proceso.setEstado(1);
		procesoService.save(proceso);
		if (proceso.getIdProceso() != 0) {
			fichaRegistroService.activaProceso(fichaRegistro);
			flash.addFlashAttribute("success", "Proceso iniciado con éxito");
			return "redirect:/procesos/procesos";
		} else
			flash.addFlashAttribute("danger", "No se pudo iniciar el proceso");
		return "redirect:/procesos/procesos";
		}
	

	@GetMapping(value = "/listaActivos")
	public String listaActivos(Model model) {

		model.addAttribute("titulo", "Lista de procesos activos");
		model.addAttribute("listaProcesos", procesoService.findByActivo());
		return "procesos/listaActivos";
	}

	@GetMapping(value = "/asignar/{id}")
	public String asignarJuicio(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {
		Proceso proceso = null;
		if (id > 0) {
			proceso = procesoService.findOne(id);
			if (proceso == null) {
				flash.addFlashAttribute("error", "El ID del proceso no existe en la BBDD!");
				return "redirect:/procesos/procesos";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del proceso  no puede ser cero!");
			return "redirect:/procesos/listaActivos";
		}
		model.addAttribute("proceso", proceso);
		model.addAttribute("titulo", "Asignar juicio");
		return "/procesos/asignar";
	}

	@PostMapping(value = "asignar")
	public String asignar(Proceso proceso, Model model, RedirectAttributes flash) {
		System.out.println("proceso recibido: " + proceso.toString());
		procesoService.save(proceso);
		flash.addFlashAttribute("success", "Juicio asignado con éxito");
		return "redirect:/procesos/listaActivos";
	}

	@GetMapping(value = "/asignarDictamen/{id}")
	public String asignarDictamen(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {
		Proceso proceso = null;
		if (id > 0) {
			proceso = procesoService.findOne(id);
			if (proceso == null) {
				flash.addFlashAttribute("error", "El ID del proceso no existe en la BBDD!");
				return "redirect:/procesos/procesos";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del proceso  no puede ser cero!");
			return "redirect:/procesos/listaActivos";
		}
		model.addAttribute("listaLotes", loteDictamenService.findAll());
		model.addAttribute("proceso", proceso);
		model.addAttribute("titulo", "Asignar dictamen");
		return "/procesos/asignarDictamen";
	}
	
	@PostMapping(value = "asignarDictamen")
	public String asignarDictamen(Proceso proceso, Model model, RedirectAttributes flash) {
		System.out.println("proceso recibido: " + proceso.toString());
		proceso.setEstado(0);
		procesoService.save(proceso);
		flash.addFlashAttribute("success", "Juicio asignado con éxito");
		return "redirect:/procesos/listaActivos";
	}
	
	
}
