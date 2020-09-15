package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		System.out.println("id recibido: " +id);
		
		
		
		return  "redirect:/finanzas/notificacionPagos";
	}
	
	
}
