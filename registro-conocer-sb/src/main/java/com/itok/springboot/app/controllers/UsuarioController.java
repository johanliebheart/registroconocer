package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.itok.springboot.app.models.service.IUsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("listar")
	public String listar (Model model) {
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listar"; 
	}

}
