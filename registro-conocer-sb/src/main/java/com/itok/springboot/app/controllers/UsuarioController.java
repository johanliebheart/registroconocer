package com.itok.springboot.app.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/usuario")
public class UsuarioController {
	/*@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("listar")
	public String listar (Model model) {
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listar"; 
	}
*/
	@GetMapping(value="/nuevoUsuario")
	public String nuevoUsuario(Model model) {
		System.out.println("entrando a nuevo usuario");
		model.addAttribute("titulo", "Nuevo usuario");
		return "usuario/nuevoUsuario";
	}
	
	
}
