package com.itok.springboot.app.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.itok.springboot.app.models.entity.Certificados;
import com.itok.springboot.app.models.entity.Proceso;
import com.itok.springboot.app.models.service.ICertificadosService;
import com.itok.springboot.app.models.service.IProcesoService;

@Controller
@RequestMapping("/certificados")
@SessionAttributes("certificados")
public class CertificadosController {

	@Autowired
	private IProcesoService procesoService;
	@Autowired
	private ICertificadosService certificadosService;

	@GetMapping("/listaCompetentes")
	public String certificados(Model model) {
		model.addAttribute("listaCompetentes", procesoService.findByCompetente());
		model.addAttribute("titulo", "Lista de procesos con juicio competente");
		return "/certificados/listaCompetentes";
	}

	@GetMapping(value = "/nuevo/{id}")
	public String nuevo(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {
		Certificados certificados = new Certificados();
		Proceso proceso = null;
		if (id > 0) {
			proceso = procesoService.findOne(id);
			if (proceso == null) {
				flash.addFlashAttribute("error", "El ID del proceso no existe en la BBDD!");
				return "redirect:/certificados/listaCompetentes";
			}
			certificados.setIdProceso(proceso);
			model.addAttribute("certificados", certificados);
			model.addAttribute("titulo", "Añadir folio de certificado");
			return "/certificados/nuevoCertificado";
		} else {
			flash.addFlashAttribute("error", "El ID de la ficha no puede ser cero!");
			return "redirect:/certificados/listaCompetentes";
		}

	}
	
	@PostMapping(value = "registrarCertificado")
	public String registrar(Certificados certificados) {
		System.out.println("controlador certificados");
		System.out.println("certificado: " +  certificados.toString());
		return "redirect:/certificados/listaCompetentes";
	}
	
/*
	@PostMapping(value = "registrarCertificado")
	public String registrar(@Valid Certificados certificados, BindingResult result, Model model,
			RedirectAttributes flash, SessionStatus status) {
		System.out.println("certificado recibido: " + certificados.toString());
		if (result.hasErrors()) {
			model.addAttribute("certificados", certificados);
			model.addAttribute("titulo", "Añadir folio de certificado");
		}

		// cambiando el estado del proceso a certificado
		Proceso proceso = null;
		proceso = procesoService.findOne(certificados.getIdProceso().getIdProceso());
		proceso.setCertificado(true);
		procesoService.save(proceso);

		String mensajeFlash = (certificados.getIdCertificado() != 0) ? "Certificado editado con éxito"
				: "Certificado registrado con éxito";
		if (certificados.getIdCertificado() == 0) {
			certificadosService.save(certificados);
			model.addAttribute("listaCompetentes", procesoService.findByCompetente());
			model.addAttribute("titulo", "Lista de procesos con juicio competente");
			flash.addFlashAttribute("success", mensajeFlash);
			status.setComplete();
			return "redirect:/certificados/listaCompetentes";
		}
		certificadosService.save(certificados);
		model.addAttribute("titulo", "Reporte de Folios de Certificados");
		model.addAttribute("listaCertificados", certificadosService.findAll());
		flash.addFlashAttribute("success", mensajeFlash);
		status.setComplete();
		return "redirect:/reportes/reporteCertificados";
	}*/

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {
		Certificados certificados = null;
		if (id > 0) {
			certificados = certificadosService.findOne(id);
			if (certificados == null) {
				flash.addFlashAttribute("error", "El ID del certificado no existe en la BBDD!");
				return "redirect:/certificados/reporteCertificados";
			}
			model.addAttribute("certificados", certificados);
			model.addAttribute("titulo", "Añadir folio de certificado");
			return "/certificados/nuevoCertificado";
		} else {
			flash.addFlashAttribute("error", "El ID del certificado no puede ser cero!");
			return "redirect:/certificados/reporteCertificados";
		}

	}

}
