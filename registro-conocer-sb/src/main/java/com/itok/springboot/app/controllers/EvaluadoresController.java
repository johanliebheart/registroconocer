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

import com.itok.springboot.app.models.entity.EstandaresAutorizados;
import com.itok.springboot.app.models.entity.EvaluadorIndependiente;
import com.itok.springboot.app.models.service.IEstandarService;
import com.itok.springboot.app.models.service.IEstandaresAutorizadosService;
import com.itok.springboot.app.models.service.IEvaluadorIndependienteService;

@Controller
@RequestMapping(value = "/evaluadores")
@SessionAttributes("evaluadorIndependiente")
public class EvaluadoresController {

	@Autowired
	private IEstandarService estandarService;
	@Autowired
	private IEvaluadorIndependienteService evaluadorIndependienteServivce;
	@Autowired
	private IEstandaresAutorizadosService estandaresAutorizadosService;
	
	
	@GetMapping("/altaEvaluador")
	public String alta(Model model) {
		EvaluadorIndependiente evaluadorIndependiente = new EvaluadorIndependiente();
		model.addAttribute("evaluadorIndependiente", evaluadorIndependiente);
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("titulo", "Alta de evaluador independiente");
		return "operaciones/evaluadores/altaEvaluador";
	}

	@PostMapping(value = "guardarEvaluador")
	public String guardar(@Valid EvaluadorIndependiente evaluadorIndependiente, BindingResult result,Model model,RedirectAttributes flash,SessionStatus status) {
		System.out.println("ei recibido: " + evaluadorIndependiente.toString());
		
		if(result.hasErrors()) {
			model.addAttribute("listaEstandar", estandarService.findAll());
			model.addAttribute("titulo", "Alta de evaluador independiente");
			return "operaciones/evaluadores/altaEvaluador";
		}
		
			String mensajeFlash=(evaluadorIndependiente.getIdEvaluadorIndependiente() != 0) ? "Evaluador editado con éxito!" : "Evaluador creado con éxito!";
			evaluadorIndependienteServivce.save(evaluadorIndependiente);
			flash.addFlashAttribute("success", mensajeFlash);
			status.setComplete();
			return "redirect:/evaluadores/altaEvaluador";
		
	}
	
	@GetMapping(value="/altaEvaluador/{id}")
	public String editar(@PathVariable(value="id") int id, Model model, RedirectAttributes flash) {
		EvaluadorIndependiente evaluadorIndependiente =null;
		
		if(id>0) {
			evaluadorIndependiente = evaluadorIndependienteServivce.findOne(id);
				if(evaluadorIndependiente == null) {
					flash.addFlashAttribute("error", "El ID del evaluador no existe en la BBDD!");
					return "redirect:/reportes/reporteEvaluadores";
				}
		} else {
			flash.addFlashAttribute("error", "El ID del evaluador no puede ser cero!");
			return "redirect:/reportes/reporteEvaluadores";		
		}
		model.addAttribute("evaluadorIndependiente", evaluadorIndependiente);
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("titulo", "Editar evaluador independiente");
		return "operaciones/evaluadores/altaEvaluador";
		
	}
	
	@GetMapping(value="/agregarEstandar/{id}")
	public String estandarAutorizado(@PathVariable(value="id") int id, Model model, RedirectAttributes flash) {
		EvaluadorIndependiente evaluadorIndependiente =null;
		EstandaresAutorizados estandaresAutorizados=new EstandaresAutorizados();
		
		if(id>0) {
			evaluadorIndependiente = evaluadorIndependienteServivce.findOne(id);
				if(evaluadorIndependiente == null) {
					flash.addFlashAttribute("error", "El ID del evaluador no existe en la BBDD!");
					return "redirect:/reportes/reporteEvaluadores";
				}
		}
		
		estandaresAutorizados.setIdEvaluadorIndependiente(evaluadorIndependiente);
		
		model.addAttribute("titulo", "Añadir estandar autorizado");
		model.addAttribute("evaluadorIndependiente", evaluadorIndependienteServivce.findOne(id));
		model.addAttribute("estandaresAutorizados", estandaresAutorizados);
		model.addAttribute("listaEstandar", estandarService.findAll());
		model.addAttribute("listaEstandaresAutorizados", evaluadorIndependienteServivce.findEstandares(id));
		
		return "operaciones/evaluadores/agregarEstandar";
	}

	@PostMapping(value="agregar")
	public String agregar(Model model, EstandaresAutorizados estandaresAutorizados, RedirectAttributes flash, SessionStatus status) {
		System.out.println("evaluador recibido: "+ estandaresAutorizados.getIdEvaluadorIndependiente().getIdEvaluadorIndependiente());
		
		estandaresAutorizadosService.save(estandaresAutorizados);
		status.setComplete();
		flash.addFlashAttribute("success", "estandar agregado con éxito");
		
		return "redirect:/evaluadores/agregarEstandar/"+estandaresAutorizados.getIdEvaluadorIndependiente().getIdEvaluadorIndependiente();
	}
	
}
