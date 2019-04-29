package edu.uabc.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uabc.app.model.Documento;
import edu.uabc.app.model.Ventana;
import edu.uabc.app.service.IDocumentoService;
import edu.uabc.app.service.IVentanaService;

@Controller
public class HomeController {
	
	@Autowired
	private IDocumentoService documentoService;
	
	@Autowired
	private IVentanaService ventanaService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String mostrarLogin() {
		return "login";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal() {
		return "home";
	}
	
	@GetMapping(value = "{id}")
	public String mostrarVentana(@RequestParam int idVentana, Model modelo) {
		
		
		
		List<Documento> listadocs = documentoService.buscarPorIdVentanaOrdenPorOrden(idVentana);
		Ventana ventana = ventanaService.buscarPorId(idVentana);
		
	modelo.addAttribute("ventana",ventana);
	modelo.addAttribute("documentos",listadocs);
		return "oficios";
	}
	
}
