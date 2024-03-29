package edu.uabc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uabc.app.model.Documento;
import edu.uabc.app.model.Usuario;
import edu.uabc.app.model.Ventana;
import edu.uabc.app.service.IDocumentoService;
import edu.uabc.app.service.IUsuarioService;
import edu.uabc.app.service.IVentanaService;
import edu.uabc.app.util.CrearMenu;

@Controller
public class HomeController {

	@Autowired
	private IVentanaService serviceVentana;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IDocumentoService serviceDocumento;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String mostrarLogin() {
		return "login";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model, Authentication authentication) {
		
		// Se agrega el nombre del usuario
		Usuario usuarioAuth = serviceUsuario.buscarPorCorreo(authentication.getName());
		model.addAttribute("usuarioAuth", usuarioAuth);
		
		// Proceso para la generación del menu por base de datos
		List<Ventana> listaMenu = serviceVentana.buscarPorIdNivelOrdenPorOrden(1);
		List<Ventana> listaSubMenu = serviceVentana.buscarPorIdNivelOrdernPorIdReferencia(2);
		
		CrearMenu crearMenu = new CrearMenu();
		String menuCompleto = crearMenu.menu(listaMenu, listaSubMenu, usuarioAuth);
		
		// Se obtiene el rol del usuario
		for(GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("Rol: " + rol.getAuthority());
			//System.out.println("Menu: " + listaMenu);
		}
		
		model.addAttribute("menuCompleto", menuCompleto);
		return "home";
	}
	
		@GetMapping(value = "/{nombre}/index")
		public String mostrarVentana(@PathVariable ("nombre") String nombre, Model model, Authentication authentication) {
		
			// Se agrega el nombre del usuario
			Usuario usuarioAuth = serviceUsuario.buscarPorCorreo(authentication.getName());
			model.addAttribute("usuarioAuth", usuarioAuth);
			
			// Proceso para la generación del menu por base de datos
			List<Ventana> listaMenu = serviceVentana.buscarPorIdNivelOrdenPorOrden(1);
			List<Ventana> listaSubMenu = serviceVentana.buscarPorIdNivelOrdernPorIdReferencia(2);
			
			CrearMenu crearMenu = new CrearMenu();
			String menuCompleto = crearMenu.menu(listaMenu, listaSubMenu, usuarioAuth);
			
			model.addAttribute("menuCompleto", menuCompleto);
			
			// Proceso para buscar por URL
			String liga = "/contaduria/";
			liga = liga.concat(nombre);
			liga = liga.concat("/index");
			Ventana ventana = serviceVentana.buscarPorLiga(liga);
			List<Documento> listaDocumento = serviceDocumento.buscarPorIdVentanaOrdenPorOrden(ventana.getIdVentana());
			//Ventana ventana = serviceVentana.buscarPorId(idVentana);
		
			model.addAttribute("ventana",ventana);
			model.addAttribute("documentos", listaDocumento);
		
			return "visualizar/oficios";
	}
}
