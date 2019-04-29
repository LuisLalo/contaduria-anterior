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

import edu.uabc.app.model.TipoDocumento;
import edu.uabc.app.service.ITipoDocumentoService;

@Controller
@RequestMapping(value="/tipoDocumento", method=RequestMethod.GET)
public class TipoDocumentoController {

	@Autowired
	private ITipoDocumentoService serviceTipoDocumento;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarTipoDocumentoo(Model model) {
		// Se busca el listado de los tipos de documentos
		List<TipoDocumento> lista = serviceTipoDocumento.buscarTodas();
		model.addAttribute("tipoDocumento", lista);
		
		return "tipoDocumento/listTipoDocumento";
	}
	
	@GetMapping("/crear")
	public String crearTipoDocumento(Model model, @ModelAttribute TipoDocumento tipoDocumento) {
		
		return "tipoDocumento/formTipoDocumento";
	}
	
	@PostMapping("/guardar")
	public String guardarTipoDocumento(@ModelAttribute TipoDocumento tipoDocumento, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "tipoDocumento/formTipoDocumento";
		}
		
		// Se hace la inserción a la base de datos
		serviceTipoDocumento.insertar(tipoDocumento);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attribute.addFlashAttribute("mensaje", "El tipo de documento fue guardado");
		
		return "redirect:/tipoDocumento/index";
	}
	
	@GetMapping("/editar/{id}")
	public String editarTipoDocumento(@PathVariable ("id") int idTipoDocumento, Model model) {
		// Se busca el registro para mostralo dentro del formulario para la edición por parte del usuario
		TipoDocumento tipoDocumento = serviceTipoDocumento.buscarPorId(idTipoDocumento);
		model.addAttribute("tipoDocumento", tipoDocumento);
		
		return "tipoDocumento/formTipoDocumento";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarTipDocumento(@PathVariable ("id") int idTipoDocumento, Model model, RedirectAttributes attributes) {
		// Se elimina el registro de la base de datos
		serviceTipoDocumento.eliminar(idTipoDocumento);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attributes.addFlashAttribute("mensaje", "La sección fue eliminada");
		
		return "redirect:/tipoDocumento/index";
	}
}
