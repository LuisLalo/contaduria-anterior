package edu.uabc.app.util;

import java.util.List;

import edu.uabc.app.model.Usuario;
import edu.uabc.app.model.Ventana;

public class CrearMenu {

	 // Método para generar el menú pase de datos
	public String menu(List<Ventana> listaMenu, List<Ventana> listaSubMenu, Usuario usuarioAuth) {
		System.out.println(listaSubMenu);
		String menuInicio = "<!-- Barra de navegación generada por BD-->\r\n" + 
				"	<div class=\"container\">\r\n" + 
				"		<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n" + 
				"			<a class=\"navbar-brand\" href=\"/contaduria/\"> \r\n" + 
				"				<img src=\"/contaduria/resources/images/ISOTIPO_Una-tinta_FONDO-OSCURO.png\" width=\"50\" height=\"30\" class=\"d-inline-block align-top\" alt=\"Inicio\">\r\n" + 
				"			</a>\r\n" + 
				"			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"				<span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"			</button>\r\n"; 
		String menuDos = "			<div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\r\n" + 
				"				<ul class=\"navbar-nav\">\r\n" + 
				"					<li class=\"nav-item dropdown\">\r\n" + 
				"					<a class=\"nav-link dropdown-toggle\" href=\"";
		
		String menuTres = "\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">";
		String menuCuatro = "</a>\r\n"+
				"						<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n";
		String menuCinco = "							<a class=\"dropdown-item\" href=\"";
		String menuSeis = "\" >";
		String menuSiete = "</a>\r\n";
		String menuFinal = "					<li class=\"nav-item\"><a class=\"nav-link\" href=\"/contaduria/logout\">Cerrar Sesión</a></li>\r\n" + 
				"				</ul>\r\n" + 
				"			</div>\r\n" + 
				"		</nav>\r\n" + 
				"	</div>\r\n";
		String usuarioInicio = "<!-- Datos del usuario -->\r\n" + 
				"	<div class=\"container marketing\">\r\n" + 
				"		<div style=\"text-align:right; \">\r\n" + 
				"			Bienvenido(a)";
		String usuarioFinal = "\r\n" + 
				"		</div>\r\n" + 
				"		<div style=\"text-align:right; \">\r\n" + 
				"			\r\n" + 
				"		</div>\r\n" + 
				"	</div>";
		
		String menuCompleto = "";
		//System.out.println(listaMenu.size());
		menuCompleto = menuInicio;
		for(int cont=0;cont<listaMenu.size();cont++) {
			System.out.println(listaMenu.get(cont));
			menuCompleto = menuCompleto.concat(menuDos);
			menuCompleto = menuCompleto.concat(listaMenu.get(cont).getLiga());
			menuCompleto = menuCompleto.concat(menuTres);
			menuCompleto = menuCompleto.concat(listaMenu.get(cont).getNombre());
			//menuCompleto = menuCompleto.concat("</a> \r\n" +
			//		 "					</li> \r\n" +
			//		 "				</ul> \r\n");
			menuCompleto = menuCompleto.concat(menuCuatro);
			System.out.println(listaSubMenu.size());
			for(int contador=0;contador<listaSubMenu.size();contador++) {
				
				int conta = cont+1;
				System.out.println("idReferencia: " + listaSubMenu.get(contador).getIdReferencia());
				System.out.println("Contador: " + contador);
				System.out.println("Nombre: " + listaSubMenu.get(contador).getNombre());
				
				if(listaSubMenu.get(contador).getIdReferencia() == conta) {
					System.out.println(listaSubMenu.get(contador).getLiga());
					menuCompleto = menuCompleto.concat(menuCinco);
					menuCompleto = menuCompleto.concat(listaSubMenu.get(contador).getLiga());
					menuCompleto = menuCompleto.concat(menuSeis);
					menuCompleto = menuCompleto.concat(listaSubMenu.get(contador).getNombre());
					menuCompleto = menuCompleto.concat(menuSiete);
				}
			}
			menuCompleto = menuCompleto.concat("						</div></li>\r\n");
		}
		menuCompleto = menuCompleto.concat(menuFinal);
		menuCompleto = menuCompleto.concat(usuarioInicio);
		menuCompleto = menuCompleto.concat(usuarioAuth.getNombre());
		menuCompleto = menuCompleto.concat(" ");
		menuCompleto = menuCompleto.concat(usuarioAuth.getApellidos());
		menuCompleto = menuCompleto.concat(usuarioFinal);
		
		return menuCompleto;
	}
}
