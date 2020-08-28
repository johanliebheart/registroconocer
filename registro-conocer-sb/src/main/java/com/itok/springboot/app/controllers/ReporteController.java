package com.itok.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itok.springboot.app.models.service.ICertificadosService;
import com.itok.springboot.app.models.service.IEvaluadorIndependienteService;
import com.itok.springboot.app.models.service.IFichaRegistroService;
import com.itok.springboot.app.models.service.ILoteDictamenService;
import com.itok.springboot.app.models.service.IProcesoService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	@Autowired
	private IFichaRegistroService fichaRegistroService;
	@Autowired
	private IEvaluadorIndependienteService evaluadoreIndependienteService;
	@Autowired
	private IProcesoService procesoService;
	@Autowired
	private ILoteDictamenService loteDictamenService;
	@Autowired
	private ICertificadosService certificadosService;


	@GetMapping(value = "/reporteFichas")
	public String reporteFichas(Model model) {
		model.addAttribute("listaFichas", fichaRegistroService.findAll());
		model.addAttribute("titulo", "Reporte de fichas");
		return "reportes/reporteFichas";
	}

	@GetMapping(value = "/reporteEvaluadores")
	public String reporteEvaluadores(Model model) {
		model.addAttribute("titulo", "Reporte de evaluadores independientes");
		model.addAttribute("listaEvaluadores", evaluadoreIndependienteService.findAll());
		return "reportes/reporteEvaluadores";
	}
	
	@GetMapping(value="/reporteProcesos")
	public String reporteProcesos(Model model) {
		model.addAttribute("titulo", "Reporte de procesos");
		model.addAttribute("listaProcesos", procesoService.findAll());
		return "reportes/reporteProcesos";
	}
	
	@GetMapping(value="/reporteLotesDictamen")
	public String reporteLotesDictamen(Model model) {
		model.addAttribute("titulo", "Reporte de Lotes de Dictamen");
		model.addAttribute("listaLotesDictamen", loteDictamenService.findAll());
		return "reportes/reporteLotesDictamen";
	}

	@GetMapping(value="/reporteCertificados")
	public String reporteCertificados(Model model) {
		model.addAttribute("titulo", "Reporte de Folios de Certificados");
		model.addAttribute("listaCertificados", certificadosService.findAll());
		return "reportes/reporteCertificados";	
		}
}
