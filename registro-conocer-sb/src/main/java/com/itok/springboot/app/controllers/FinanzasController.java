package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itok.springboot.app.models.entity.Certificado;
import com.itok.springboot.app.models.service.ICertificadoService;


@Controller
@RequestMapping("finanzas")
public class FinanzasController {

	@Autowired
	ICertificadoService certificadoCervice;
	
	@GetMapping("notificacionPagos")
	public String listaCert(Model model) {
		model.addAttribute("titulo", "Lista de folios de certificado");
		model.addAttribute("listaCertificados", certificadoCervice.findByActivo());
		return "/finanzas/notificacionPagos";
	}
		
	@GetMapping("asignarPago/{id}")
	public String asignar(@PathVariable(value="id") int id, Model model, RedirectAttributes flash) {
		Certificado certificado=null;
		
		if (id > 0) {
			certificado= certificadoCervice.findOne(id);
			if(certificado ==null) {
				flash.addFlashAttribute("error", "El ID del certificado no existe en la BBDD!");
				return "redirect:/finanzas/notificacionPagos";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del certificado no puede ser cero!");
			return "redirect:/finanzas/notificacionPagos";
		}
		model.addAttribute("titulo", "Asignar nuevo pago");
		model.addAttribute("certificado", certificado);
		return "/finanzas/nuevoPago";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}