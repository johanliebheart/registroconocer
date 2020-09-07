package com.itok.springboot.app.controllers;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itok.springboot.app.models.entity.LoteDictamen;
import com.itok.springboot.app.models.service.ILoteDictamenService;

@Controller
@RequestMapping("/lote")
@SessionAttributes("loteDictamen")
public class LoteController {

	@Autowired
	private ILoteDictamenService loteDictamenService;
	
	@GetMapping("/loteDictamen")
	public String loteDictamen(Model model) {
		model.addAttribute("listaLotes", loteDictamenService.findAll());
		model.addAttribute("titulo", "Administración de lotes de dictamen");
		return"/lote/loteDictamen";
	}
	
	@GetMapping("/nuevoLote")
	public String nuevoLote(Model model) {		
		LoteDictamen loteDictamen = new LoteDictamen();
		model.addAttribute("loteDictamen", loteDictamen);
		model.addAttribute("titulo", "Nuevo lote de dictamen");
		return "/lote/nuevoLote";
	}
	
	
	

	@PostMapping("/guardarLote")	
	public String guardarLote(@Valid LoteDictamen loteDictamen, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status ) {
		System.out.println("lote recibido: " + loteDictamen.toString());
		if(result.hasErrors()) {
			model.addAttribute("loteDictamen", loteDictamen);
			model.addAttribute("titulo","Nuevo lote de dictamen");
			return "/lote/nuevoLote";
		}
		String mensajeFlash=(loteDictamen.getFechaCapturada() != null) ? "Lote editado con éxito" : "Lote creado con éxito";
		loteDictamen.setContador(loteDictamen.getNumeroFichas());
		loteDictamenService.save(loteDictamen);
		flash.addFlashAttribute("success", mensajeFlash);
		status.setComplete();
		return "redirect:/lote/loteDictamen";
	}
	
	@GetMapping(value="/nuevoLote/{id}")
	public String editarLote(@PathVariable(value="id") int id, Model model, RedirectAttributes flash) {
		LoteDictamen loteDictamen= null;
		boolean estado=false;
		if(id>0) {
			loteDictamen=loteDictamenService.findOne(id);
			if(loteDictamen==null) {
				flash.addFlashAttribute("error", "El lote de dictamen ingresado no existe");
				return "redirect:/lote/loteDictamen";
			}
		}else {
			flash.addFlashAttribute("error", "el id de lote no puede ser cero");
			return "redirect:/lote/loteDictamen";
		}
		
		model.addAttribute("loteDictamen", loteDictamen);
		model.addAttribute("titulo", "Editar lote de dictamen");
		model.addAttribute("estado", estado);
		return "/lote/nuevoLote";
	}
	
	@GetMapping(value="/asignarEstado/{id}")
	public String asignarEstado(@PathVariable(value="id") int id, Model model, RedirectAttributes flash) {
		LoteDictamen loteDictamen= null;
		boolean estado=true;
		if(id>0) {
			loteDictamen=loteDictamenService.findOne(id);
			if(loteDictamen==null) {
				flash.addFlashAttribute("error", "El lote de dictamen ingresado no existe");
				return "redirect:/lote/loteDictamen";
			}
		}else {
			flash.addFlashAttribute("error", "el id de lote no puede ser cero");
			return "redirect:/lote/loteDictamen";
		}
		
		model.addAttribute("loteDictamen", loteDictamen);
		model.addAttribute("titulo", "Editar lote de dictamen");
		model.addAttribute("estado", estado);
		return "/lote/nuevoLote";
	}
	
	
}
