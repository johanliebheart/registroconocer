package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.itok.springboot.app.models.entity.Certificado;
import com.itok.springboot.app.models.entity.Proceso;
import com.itok.springboot.app.models.service.ICertificadoService;
import com.itok.springboot.app.models.service.IProcesoService;

@Controller
@RequestMapping("/certificados")
@SessionAttributes("certificado")
public class CertificadoController {

	@Autowired
	private IProcesoService procesoService;
	@Autowired
	private ICertificadoService certificadoService;
	
	@GetMapping("/listaCompetentes")
	public String listaCompetentes(Model model) {
		model.addAttribute("titulo", "Lista de proceso con juicio competente");
		model.addAttribute("listaCompetentes", procesoService.findByCompetente());
		return "certificados/listaCompetentes";
	}
	
	@GetMapping("nuevo/{id}")
	public String nuevo(@PathVariable(value="id") int id, Model model, RedirectAttributes flash) {
		Certificado certificado = new Certificado();
		Proceso proceso= null;
		
		if (id > 0) {
			proceso= procesoService.findOne(id);
			if (proceso == null) {
				flash.addFlashAttribute("error", "El ID del proceso no existe en la BBDD!");
				return "redirect:/certificados/listaCompetentes";
			}

			certificado.setIdProceso(proceso);
			model.addAttribute("certificado", certificado);
			model.addAttribute("titulo", "Añadir folio de certificado");
			return "/certificados/nuevoCertificado";
		}else 
			flash.addFlashAttribute("error", "El ID de la ficha no puede ser cero!");
			return "redirect:/certificados/listaCompetentes";
		
	}
	
	
	@PostMapping("registrarCertificado")
	public String registrar(Certificado certificado,Model model, RedirectAttributes flash, SessionStatus status) {
		
		// cambiando el estado del proceso a certificado
				Proceso proceso = null;
				proceso = procesoService.findOne(certificado.getIdProceso().getIdProceso());
				proceso.setCertificado(true);
				procesoService.save(proceso);
				
				String mensajeFlash = (certificado.getIdCertificado() != 0) ? "Certificado editado con éxito" : "Certificado registrado con éxito";
				
				if (certificado.getIdCertificado() == 0) {
					certificadoService.save(certificado);
					model.addAttribute("listaCompetentes", procesoService.findByCompetente());
					model.addAttribute("titulo", "Lista de procesos con juicio competente");
					flash.addFlashAttribute("success", mensajeFlash);
					status.setComplete();
					return "redirect:/certificados/listaCompetentes";
				}
				
				certificadoService.save(certificado);
				model.addAttribute("titulo", "Reporte de Folios de Certificados");
				model.addAttribute("listaCertificados", certificadoService.findAll());
				flash.addFlashAttribute("success", mensajeFlash);
				status.setComplete();
				return "redirect:/reportes/reporteCertificados";
		
	}
}
