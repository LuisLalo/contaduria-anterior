package edu.uabc.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.uabc.app.model.Documento;
import edu.uabc.app.model.Ventana;
import edu.uabc.app.service.IDocumentoService;
import edu.uabc.app.service.IVentanaService;
import edu.uabc.app.util.Utileria;

@Controller
@RequestMapping(value="/documento", method=RequestMethod.GET)
public class DocumentoController {

	@Autowired
	private IVentanaService serviceVentana;
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarDocumento(Model model) {
		List<Documento> lista = serviceDocumento.buscarTodas();
		model.addAttribute("documento", lista);
		
		return "documento/listDocumento";
	}
	
	@GetMapping("/crear")
	public String crearDocumento(Model model, @ModelAttribute Documento documento) {
		// Se busca el listado de secciones para mostrarlo en el formulario
		List<Ventana> lista = serviceVentana.buscarTodas();
		model.addAttribute("ventana", lista);
		
		return "documento/formDocumento";
	}
	
	@PostMapping("/guardar")
	public String guardarDocumento(@ModelAttribute Documento documento, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "documento/formDocumento";
		}
		
		// Se identifica el número que el usuario puso en el orden y la ventana en donde aparecerá el documento para modificar el consecutivo del listado de documentos
		// Se obtiene el orden del documento
		int orden = documento.getOrden();
		
//		List<Documento> listaDocumento =
		
		
		// Se busca el lista de las ventanas para buscar a cual le corresponde para guardar la liga del documento
		List<Ventana> listaVentana = serviceVentana.buscarTodas();
		
		// Se busca la ventana en donde aparecerá el documento para que se guarde en esa carpeta
		String liga = Utileria.obtenerVentana(documento.getIdVentana(), listaVentana);
		
		// Se hace la inserción a la base de datos
		serviceDocumento.insertar(documento);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attribute.addFlashAttribute("mensaje", "El documento fue guardado");
		
		return "redirect:/documento/index";
		
	}
	
	@GetMapping("/nuevo")
	public String crearDocumentoInforme(Model model) {
		return "documento/formDocumentoInforme";
	}
}
