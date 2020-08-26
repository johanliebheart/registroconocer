package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.itok.springboot.app.models.entity.Usuario;
import com.itok.springboot.app.models.service.IUsuarioService;

@Controller("/")
public class AccesController {
	@Autowired
	IUsuarioService usuarioService;

	@GetMapping
	public String login(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "login";
	}

	@PostMapping(value = "/login")
	public String login(Model model, Usuario usuario, RedirectAttributes flash) {
		System.out.println("El usuario recibido es: " + usuario.toString());
			
		 if (usuario.getIdUsuario() > 0) {
			boolean a=usuarioService.validateUser(usuario);
			int i=usuarioService.typeUser(usuario);
			if (a) {
				System.out.println("tipo de usuario: " + i);
				flash.addFlashAttribute("success", "Acceso correcto");
				model.addAttribute("titulo", "Index");
				return "index";
			}else 
				flash.addFlashAttribute("error", "El usuario no existe o la contraseña es incorrecta");
				return "redirect:/";
		} else 
			flash.addFlashAttribute("error", "El Id del usuario no puede ser 0");
			return "redirect:/";	
	}
	
	@GetMapping(value="{inicio,index}")
	public String inicio(Model model) {
		
		return "index";
	}

}

