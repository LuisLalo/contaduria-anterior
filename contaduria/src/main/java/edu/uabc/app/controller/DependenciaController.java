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

import edu.uabc.app.model.Dependencia;
import edu.uabc.app.service.IDependenciaService;

@Controller
@RequestMapping(value="/dependencia")
public class DependenciaController {

	@Autowired
	private IDependenciaService serviceDependencia;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarDependencia(Model model) {
		// Se busca el listado de Dependencias para mostrarlo en la vista
		List<Dependencia> lista = serviceDependencia.buscarTodas();
		model.addAttribute("dependencia", lista);
		return "dependencia/listDependencia";
	}
	
	@GetMapping("/crear")
	public String nuevaDependencia(Model model, @ModelAttribute Dependencia dependencia) {
		return "dependencia/formDependencia";
	}
	
	@PostMapping("/guardar")
	public String guardarDependencia(@ModelAttribute Dependencia dependecia, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "dependencia/formDependencia";
		}
		
		// Se hace la inserción a la base de datos
		serviceDependencia.insertar(dependecia);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attribute.addFlashAttribute("mensaje", "El registro fue guardado");
		
		return "redirect:/dependencia/index";
	}
	
	@GetMapping("/editar/{id}")
	public String editarDependencia(@PathVariable("id") int idDependencia, Model model) {
		// Se busca el registro para mostralo dentro del formulario para la edición por parte del usuario
		Dependencia dependencia = serviceDependencia.buscarPorId(idDependencia);
		model.addAttribute("dependencia", dependencia);
		
		return "dependencia/formDependencia";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarDependencia(@PathVariable("id") int idDependencia, RedirectAttributes attributes) {
		// Se elimina el registro de la base de datos
		serviceDependencia.eliminar(idDependencia);
		
		attributes.addFlashAttribute("mensaje", "La dependencia fue eliminada");
		return "redirect:/dependencia/index";
	}
}
