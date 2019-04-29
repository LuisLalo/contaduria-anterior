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

import edu.uabc.app.model.TipoUsuario;
import edu.uabc.app.service.ITipoUsuarioService;

@Controller
@RequestMapping(value="/rol", method=RequestMethod.GET)
public class RolController {

	@Autowired
	private ITipoUsuarioService serviceTipoUsuario;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarRol(Model model) {
		// Se busca el listado de los roles de los usuarios
		List<TipoUsuario> lista = serviceTipoUsuario.buscarTodas();
		model.addAttribute("tipoUsuario", lista);
		
		return "rol/listRol";
		
	}
	
	@GetMapping("/crear")
	public String crearRol(Model model, @ModelAttribute TipoUsuario tipoUsuario) {
		
		return "rol/formRol";
	}
	
	@PostMapping("/guardar")
	public String guardarRol(@ModelAttribute TipoUsuario tipoUsuario, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "rol/formRol";
		}
		
		// Se hace la inserción a la base de datos
		serviceTipoUsuario.insertar(tipoUsuario);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attribute.addFlashAttribute("mensaje", "El rol fue guardado");
		
		return "redirect:/rol/index";
	}
	
	@GetMapping("/editar/{id}")
	public String editarSeccion(@PathVariable ("id") int idTipoUsuario, Model model) {
		// Se busca el registro para mostralo dentro del formulario para la edición por parte del usuario
		TipoUsuario tipoUsuario = serviceTipoUsuario.buscarPorId(idTipoUsuario);
		model.addAttribute("tipoUsuario", tipoUsuario);
		
		return "rol/formRol";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSeccion(@PathVariable ("id") int idTipoUsuario, Model model, RedirectAttributes attributes) {
		// Se elimina el registro de la base de datos
		serviceTipoUsuario.eliminar(idTipoUsuario);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attributes.addFlashAttribute("mensaje", "La sección fue eliminada");
		
		return "redirect:/rol/index";
	}
}
