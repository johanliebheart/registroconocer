package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itok.springboot.app.models.entity.Estandar;
import com.itok.springboot.app.models.service.IEstandarService;

@Controller
@RequestMapping("/estandar")
@SessionAttributes("estandar")
public class EstandarController {

	@Autowired
	private IEstandarService estandarService;
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Estandar estandar= new Estandar();
		model.addAttribute("estandar", estandar);
		model.addAttribute("titulo", "Nuevo Estandar");
		return "estandar/nuevo";
	}
	
	@PostMapping(value="registrar")
	public String registrar(Estandar estandar, Model model, RedirectAttributes flash) {
		System.out.println("Estandar recibido: "+ estandar.toString());
		estandarService.save(estandar);
		flash.addFlashAttribute("success", "Estandar registrado exitosamente");
		model.addAttribute("titulo", "Reporte de estandares");
		return "redirect:/reportes/reporteEstandares";
	}
	
	
}
