package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.itok.springboot.app.models.entity.FichaRegistro;
import com.itok.springboot.app.models.service.IEstandarService;
import com.itok.springboot.app.models.service.IEvaluadorIndependienteService;


@Controller
@SessionAttributes("fichaRegistro")
@RequestMapping(value="/public")
public class PublicController {
	
	@Autowired
	private IEvaluadorIndependienteService eiservice;
	@Autowired
	private IEstandarService estandarService;


	@GetMapping("/fichaRegistroPublica")
	public String fichaRegistro(Model model) {
		System.out.println("entrando al controller registro de ficha");

		FichaRegistro fichaRegistro = new FichaRegistro();
		model.addAttribute("titulo", "Registro de fichas por administrador");
		model.addAttribute("listaEI", eiservice.findAll());
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("fichaRegistro", fichaRegistro);
		return "public/fichaRegistroPublica";
	}
	
	
}
