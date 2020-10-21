package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itok.springboot.app.models.entity.Certificado;
import com.itok.springboot.app.models.service.ICertificadoService;

@Controller
@RequestMapping("emision")
@SessionAttributes("certificado")
public class EmisionController {

	@Autowired
	private ICertificadoService certificadoService;

	@GetMapping("listadoEmision")
	public String listadoEmision(Model model) {
		model.addAttribute("titulo", "Lista de emisiones para impresión");
		model.addAttribute("listaCertificados", certificadoService.findByEmision());
		return "emision/listadoEmision";
	}

	
	@GetMapping("/terminarEmision/{id}")
	public String terminar(@PathVariable(value = "id") int id, Model model, RedirectAttributes flash) {
		Certificado certificado = null;
		if (id > 0) {
			certificado = certificadoService.findOne(id);
			if (certificado == null) {
				flash.addFlashAttribute("error", "El certificado ingresado no existe");
				return "redirect:/emision/listadoEmision";
			}
		}else {
				flash.addFlashAttribute("error", "El id del certificado no puede ser cero");
				return "redirect:/emision/listadoEmision";
			}
		
		certificado.setEstado(false);
		
		certificadoService.save(certificado);
		flash.addFlashAttribute("success", "Certificado desactivado con éxito");
		return "redirect:/emision/listadoEmision";
	}
	
	
	
}
