package edu.uabc.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import edu.uabc.app.model.Estatus;
import edu.uabc.app.model.TipoUsuario;
import edu.uabc.app.model.Usuario;
import edu.uabc.app.model.Ventana;
import edu.uabc.app.service.IDependenciaService;
import edu.uabc.app.service.IEstatusService;
import edu.uabc.app.service.ITipoUsuarioService;
import edu.uabc.app.service.IUsuarioService;
import edu.uabc.app.service.IVentanaService;
import edu.uabc.app.util.CrearMenu;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private IDependenciaService serviceDependencia;
	
	@Autowired
	private ITipoUsuarioService serviceTipoUsuario;
	
	@Autowired
	private IEstatusService serviceEstatus;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IVentanaService serviceVentana;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarUsuario(Model model, Authentication authentication) {
		
		// Se agrega el nombre del usuario
		Usuario usuarioAuth = serviceUsuario.buscarPorCorreo(authentication.getName());
		model.addAttribute("usuarioAuth", usuarioAuth);
		
		// Proceso para la generación del menu por base de datos
		List<Ventana> listaMenu = serviceVentana.buscarPorIdNivelOrdenPorOrden(1);
		List<Ventana> listaSubMenu = serviceVentana.buscarPorIdNivelOrdernPorIdReferencia(2);
		
		CrearMenu crearMenu = new CrearMenu();
		String menuCompleto = crearMenu.menu(listaMenu, listaSubMenu, usuarioAuth);
		
		model.addAttribute("menuCompleto", menuCompleto);
		
		// Se buscan el listado de los usuarios
		List<Usuario> lista = serviceUsuario.buscarTodas();
		model.addAttribute("usuario", lista);
		
		return "usuario/listUsuario";
	}
	
	@GetMapping("/crear")
	public String nuevoUsuario(Model model, @ModelAttribute Usuario usuario, Authentication authentication) {
		
		// Se agrega el nombre del usuario
		Usuario usuarioAuth = serviceUsuario.buscarPorCorreo(authentication.getName());
		model.addAttribute("usuarioAuth", usuarioAuth);
				
		// Proceso para la generación del menu por base de datos
		List<Ventana> listaMenu = serviceVentana.buscarPorIdNivelOrdenPorOrden(1);
		List<Ventana> listaSubMenu = serviceVentana.buscarPorIdNivelOrdernPorIdReferencia(2);
			
		CrearMenu crearMenu = new CrearMenu();
		String menuCompleto = crearMenu.menu(listaMenu, listaSubMenu, usuarioAuth);
				
		model.addAttribute("menuCompleto", menuCompleto);
		
		// Se busca el listado de las dependencias
		List<Dependencia> listaDependencia = serviceDependencia.buscarTodas();
		model.addAttribute("dependencia", listaDependencia);
		
		// Se busca el tipo de usuario
		List<TipoUsuario> listaTipoUsuario = serviceTipoUsuario.buscarTodas();
		model.addAttribute("tipoUsuario", listaTipoUsuario);
		
		// Se busca el estatus del usuario
		List<Estatus> listaEstatus = serviceEstatus.buscarTodas();
		model.addAttribute("estatus", listaEstatus);
		
		return "usuario/formUsuario";
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attribute, HttpServletRequest request) {
		
		// Se verifica que no presentaron errores
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			// Se vuelve a presentar el formulario al usuario para que efectue los cambios
			return "usuario/formUsuario";
		}
		
		// Encriptación del password de los usuarios
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(hashedPassword);
		
		// Se hace la inserción a la base de datos
		serviceUsuario.insertar(usuario);
		
		// Se muestra el mensaje que el registro fue guardado exitosamente
		attribute.addFlashAttribute("mensaje", "El registro fue guardado");
		
		return "redirect:/usuario/index";
	}
	
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable ("id") int idUsuario, Model model, Authentication authentication) {
		
		// Se agrega el nombre del usuario
		Usuario usuarioAuth = serviceUsuario.buscarPorCorreo(authentication.getName());
		model.addAttribute("usuarioAuth", usuarioAuth);
				
		// Proceso para la generación del menu por base de datos
		List<Ventana> listaMenu = serviceVentana.buscarPorIdNivelOrdenPorOrden(1);
		List<Ventana> listaSubMenu = serviceVentana.buscarPorIdNivelOrdernPorIdReferencia(2);
				
		CrearMenu crearMenu = new CrearMenu();
		String menuCompleto = crearMenu.menu(listaMenu, listaSubMenu, usuarioAuth);
				
		model.addAttribute("menuCompleto", menuCompleto);
		
		// Se busca el listado de las dependencias
		List<Dependencia> listaDependencia = serviceDependencia.buscarTodas();
		model.addAttribute("dependencia", listaDependencia);
		
		// Se busca el tipo de usuario
		List<TipoUsuario> listaTipoUsuario = serviceTipoUsuario.buscarTodas();
		model.addAttribute("tipoUsuario", listaTipoUsuario);
		
		// Se busca el estatus del usuario
		List<Estatus> listaEstatus = serviceEstatus.buscarTodas();
		model.addAttribute("estatus", listaEstatus);
		
		// Se busca la información del usuario para mostrarlo en el formulario
		Usuario usuario = serviceUsuario.buscarPorId(idUsuario);
		model.addAttribute("usuario", usuario);
		
		return "usuario/formUsuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable ("id") int idUsuario, RedirectAttributes attributes) {
		// Se elimina el registro de la base de datos
		serviceUsuario.eliminar(idUsuario);
		
		attributes.addFlashAttribute("mensaje", "El usuario fue eliminado");
		return "redirect:/usuario/index";
	}
}
