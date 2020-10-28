package com.itok.springboot.app.controllers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itok.springboot.app.models.dao.IUsuarioDao;
import com.itok.springboot.app.models.entity.Role;
import com.itok.springboot.app.models.entity.Usuario;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private IUsuarioDao usuarioDao;

	@GetMapping(value="/nuevoUsuario")
	public String nuevoUsuario(Model model) {
		System.out.println("entrando a nuevo usuario");
		
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Nuevo usuario");
		model.addAttribute("usuario", usuario);
		return "usuario/nuevoUsuario";
	}
	
	@PostMapping(value="registrarUsuario")
	public String registrarUsuario(Usuario usuario, Model model,RedirectAttributes flash, SessionStatus status) {
		
		String mensajeFlash=(usuario.getIdUsuario() != 0 ) ? "Usuario editado con éxito" : "Usuario creado con éxito";
		
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		//System.out.println("password encriptado: " + usuario.getPassword());
		Role rol= new Role();
		Role rol2= new Role();
		Role rol3= new Role();
		List<Role> role = new ArrayList<Role>();
		//System.out.println("usuario recibido: " + usuario.toString());
		
		if(usuario.getTemp()==0) {
		//	System.out.println("llenando al admin");
			rol.setAuthority("ROLE_ADMIN");
			role.add(rol);
			rol2.setAuthority("ROLE_EDITOR");
			role.add(rol2);
			rol3.setAuthority("ROLE_USER");
			role.add(rol3);
		}else if (usuario.getTemp()==1) {
			System.out.println("llenando al editor");
			rol2.setAuthority("ROLE_EDITOR");
			role.add(rol2);
			rol3.setAuthority("ROLE_USER");
			role.add(rol3);
		}else if (usuario.getTemp()==2) {
			System.out.println("llenando al usuario");
			rol3.setAuthority("ROLE_USER");
			role.add(rol3);
		
		}
		
			usuario.setRoles(role);
			
			System.out.println("lista de roles asignados: ");
			Iterator<Role> iter = role.iterator();
			while (iter.hasNext())
			  System.out.println(iter.next());
		
			usuarioDao.save(usuario);
			
		
		status.setComplete();
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/usuario/nuevoUsuario";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
