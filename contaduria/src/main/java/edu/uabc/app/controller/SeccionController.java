package edu.uabc.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.uabc.app.model.Ventana;
import edu.uabc.app.service.IVentanaService;

@Controller
@RequestMapping(value="/seccion", method=RequestMethod.GET)
public class SeccionController {

	@Autowired
	private IVentanaService serviceVentana;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarSeccion(Model model) {
		// Se busca el listado de secciones
		List<Ventana> lista = serviceVentana.buscarTodas();
		model.addAttribute("seccion", lista);
		
		return "seccion/listSeccion";
	}
	
	@GetMapping("/crear")
	public String crearSeccion(Model model, @ModelAttribute Ventana ventana) {
		// Se busca el listado de Secciones para mostrarlo en la vista
		List<Ventana> lista = serviceVentana.buscarTodas();
		model.addAttribute("seccion", lista);
		
		return "seccion/formSeccion";
	}
	
	@PostMapping("/guardar")
	public String guardarSeccion(@ModelAttribute Ventana ventana, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "seccion/formSeccion";
		}
		
		// Se hace la inserci�n a la base de datos
		serviceVentana.insertar(ventana);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attribute.addFlashAttribute("mensaje", "El registro fue guardado");
		
		return "redirect:/seccion/index";
	}
	
	@GetMapping("/editar/{id}")
	public String editarSeccion(@PathVariable ("id") int idVentana, Model model) {
		// Se busca el registro para mostralo dentro del formulario para la edici�n por parte del usuario
		Ventana ventana = serviceVentana.buscarPorId(idVentana);
		model.addAttribute("ventana", ventana);
		
		return "seccion/formSeccion";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSeccion(@PathVariable ("id") int idVentana, RedirectAttributes attributes) {
		// Se elimina el registro de la base de datos
		serviceVentana.eliminar(idVentana);
		
		attributes.addFlashAttribute("mensaje", "La secci�n fue eliminada");
		return "redirect:/seccion/index";
	}
}
