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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.uabc.app.model.Documento;
import edu.uabc.app.model.TipoDocumento;
import edu.uabc.app.model.Ventana;
import edu.uabc.app.service.IDocumentoService;
import edu.uabc.app.service.ITipoDocumentoService;
import edu.uabc.app.service.IVentanaService;
import edu.uabc.app.util.Utileria;

@Controller
@RequestMapping(value="/documento", method=RequestMethod.GET)
public class DocumentoController {

	@Autowired
	private IVentanaService serviceVentana;
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@Autowired
	private ITipoDocumentoService serviceTipoDocumento;
	
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
	public String guardarDocumento(@ModelAttribute Documento documento, BindingResult result, RedirectAttributes attribute, HttpServletRequest request, @RequestParam("archivo") MultipartFile multiPart) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "documento/formDocumento";
		}
		
		// Se busca el lista de las ventanas para buscar a cual le corresponde para guardar la liga del documento
		List<Ventana> listaVentana = serviceVentana.buscarTodas();
		
		// Se busca la ventana en donde aparecer� el documento para que se guarde en esa carpeta
		String ventana = Utileria.obtenerVentana(documento.getIdVentana(), listaVentana);
		
		// Se identifica el n�mero que el usuario puso en el orden y la ventana en donde aparecer� el documento para modificar el consecutivo del listado de documentos
		// Se obtiene el orden del documento
		int orden = documento.getOrden();
		
		List<Documento> listaDocumento = serviceDocumento.buscarPorIdVentanaOrdenPorOrden(documento.getIdVentana());
		
		if (listaDocumento.isEmpty()) {
			orden = 1;
			documento.setOrden(orden);
		}
		
		serviceDocumento.actualizarOrdenNuevo(orden+1, listaDocumento);
		
		// Se identifica la extensi�n del archivo que se va a guardar y se inserta en la variable
		String extension = Utileria.agregarExtensionArchivos(multiPart);
		
		List<TipoDocumento> listaTipoDocumento = serviceTipoDocumento.buscarTodas();
		
		int idTipoArchivo = Utileria.identificarExtensionArchivos(extension, listaTipoDocumento);
		
		extension = extension.toLowerCase();
		
		documento.setIdTipoDocumento(idTipoArchivo);
		
		if (!multiPart.isEmpty()) {
			String nombreDocumento = Utileria.guardarDocumento(multiPart, request, extension, ventana);
			documento.setLiga(nombreDocumento);
		}
		
		// Se hace la inserci�n a la base de datos
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
