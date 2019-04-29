package edu.uabc.app.util;

import java.util.List;

import edu.uabc.app.model.Ventana;

public class CrearMenu {

	 // Método para generar el menú pase de datos
	public String menu(List<Ventana> menu, List<Ventana> subMenu) {
		
		String menuInicio = "<!-- Barra de navegación -->\r\n" + 
				"	<div class=\"container\">\r\n" + 
				"		<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n" + 
				"			<a class=\"navbar-brand\" href=\"/contaduria/\"> \r\n" + 
				"				<img src=\"/contaduria/resources/images/ISOTIPO_Una-tinta_FONDO-OSCURO.png\" width=\"50\" height=\"30\" class=\"d-inline-block align-top\" alt=\"Inicio\">\r\n" + 
				"			</a>\r\n" + 
				"			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"				<span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"			</button>\r\n" + 
				"			<div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\r\n" + 
				"				<ul class=\"navbar-nav\">\r\n" + 
				"					<li class=\"nav-item dropdown\">\r\n" + 
				"					<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Contabilidad </a>\r\n" + 
				"						<div class=\"dropdown-menu\"\r\n" + 
				"							aria-labelledby=\"navbarDropdownMenuLink\">\r\n" + 
				"							 \r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/oficios?idParam1=13\"  onclick=\"oficios\">Oficios de Cierre de Ejercicio</a>\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/cont_gob?idParam1=12\">Contabilidad Gubernamental</a> \r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/LineamientosContables?idParam1=11\">Lineamientos Contables</a>\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/capacitaciones?idParam1=14\">Capacitaciones</a>\r\n" + 
				"						\r\n" + 
				"						</div></li>\r\n" + 
				"					<li class=\"nav-item dropdown\"><a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">PFCE </a>\r\n" + 
				"						<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/politicas?idParam1=8\">Políticas</a>\r\n" + 
				"						</div></li>\r\n" + 
				"					<li class=\"nav-item dropdown\">\r\n" + 
				"				\r\n" + 
				"					<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Herramientas </a>\r\n" + 
				"						<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/usuario/index\">Usuarios</a> \r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/seccion/index\">Secciones</a> \r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/documento/index\">Documentos</a>\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/dependencia/index\">Dependencias</a>\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/rol/index\">Roles</a>\r\n" + 
				"							<a class=\"dropdown-item\" href=\"/contaduria/tipoDocumento/index\">Tipo de Documentos</a>\r\n" + 
				"						</div></li>\r\n" + 
				"						 \r\n" + 
				"								<li class=\"nav-item dropdown\">\r\n" + 
				"					<li class=\"nav-item\"><a class=\"nav-link\" href=\"/contaduria/cierre/principal\">Cierres Contables</a></li>\r\n" + 
				"					<li class=\"nav-item dropdown\">\r\n" + 
				"					<li class=\"nav-item\"><a class=\"nav-link\" href=\"/contaduria/logout\">Cerrar Sesión</a></li>\r\n" + 
				"				</ul>\r\n" + 
				"			</div>\r\n" + 
				"		</nav>\r\n" + 
				"	</div>\r\n" + 
				"";
		
		String menuCompleto = "";
		
		return menuCompleto;
	}
}
