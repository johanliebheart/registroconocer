package com.itok.springboot.app.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itok.springboot.app.models.service.ICandidatoService;
import com.itok.springboot.app.models.service.IEvaluadorIndependienteService;
import com.itok.springboot.app.models.service.IFichaRegistroService;
import com.itok.springboot.app.models.service.IProcesoService;
@Controller
public class AccesController {
	//@Autowired
	//IUsuarioService usuarioService;
	@Autowired
	private IFichaRegistroService fichaRegistro;
	@Autowired
	private IProcesoService procesoService;
	@Autowired
	private ICandidatoService candidatoService;
	@Autowired
	private IEvaluadorIndependienteService evaluadorService;
	

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			Principal principal, Model model, RedirectAttributes flash) {
		if(principal != null) {
			flash.addFlashAttribute("info", "El usuario ya había iniciado sesión !!!" );
			return "redirect:/inicio";
		}
		
		if(error != null) {
			flash.addFlashAttribute("error", "Nombre de usuario o contraseña incorrecta, favor de intentar nuevamente");
			return "redirect:/login";
		}
		
		return "login";
		//Usuario usuario = new Usuario();
		//model.addAttribute("usuario", usuario);
	}
	/*
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
	*/
	@GetMapping(path = {"inicio", "index","/"})
	public String inicio(Model model) {
		System.out.println("numero de fichas: " + fichaRegistro.findAll().size());
		model.addAttribute("fichas", fichaRegistro.findAll().size());
		model.addAttribute("procesos", procesoService.findAll().size());
		model.addAttribute("candidatos", candidatoService.findAll().size());
		model.addAttribute("evaluadores", evaluadorService.findAll().size());
		return "index";
	}

}

