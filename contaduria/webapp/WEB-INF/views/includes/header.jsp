<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/resources" var="urlResources"></spring:url>


<!-- Encabezado -->
	<div class="container">
		<div class="row">
		<div class="col-md-2 text-center">
			<img src="${ urlResources }/images/uabc-escudo.png" width="150" height="150" class="d-inline-block align-top" alt="Inicio">
		</div>
		<div class="col-md-10">
		<br><h1 class="center-text">UNIVERSIDAD AUTÓNOMA DE BAJA CALIFORNIA<br>Contaduría</h1></div>
		</div>
	</div>
	
<!-- Menu -->

<spring:url value="/" var="urlRoot" />
<spring:url value="/resources" var="urlResources"></spring:url>
<!-- Barra de navegación -->
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="${ urlRoot }"> 
				<img src="${ urlResources }/images/ISOTIPO_Una-tinta_FONDO-OSCURO.png" width="50" height="30" class="d-inline-block align-top" alt="Inicio">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Contabilidad </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							 
							<a class="dropdown-item" href="${ urlRoot }oficios?idParam1=13"  onclick="oficios">Oficios de Cierre de Ejercicio</a>
							<a class="dropdown-item" href="${ urlRoot }cont_gob?idParam1=12">Contabilidad Gubernamental</a> 
							<a class="dropdown-item" href="${ urlRoot }LineamientosContables?idParam1=11">Lineamientos Contables</a>
							<a class="dropdown-item" href="${ urlRoot }capacitaciones?idParam1=14">Capacitaciones</a>
						
						</div></li>
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">PFCE </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="${ urlRoot }politicas?idParam1=8">Políticas</a>
						</div></li>
					<li class="nav-item dropdown">
				<%-- 	<sec:authorize access="hasAnyAuthority('Administrador')"> --%>
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Herramientas </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="${ urlRoot }usuario/index">Usuarios</a> 
							<a class="dropdown-item" href="${ urlRoot }seccion/index">Secciones</a> 
							<a class="dropdown-item" href="${ urlRoot }documento/index">Documentos</a>
							<a class="dropdown-item" href="${ urlRoot }dependencia/index">Dependencias</a>
							<a class="dropdown-item" href="${ urlRoot }rol/index">Roles</a>
							<a class="dropdown-item" href="${ urlRoot }tipoDocumento/index">Tipo de Documentos</a>
						</div></li>
						 <%-- </sec:authorize> --%>
								<li class="nav-item dropdown">
					<li class="nav-item"><a class="nav-link" href="${ urlRoot }cierre/principal">Cierres Contables</a></li>
					<li class="nav-item dropdown">
					<li class="nav-item"><a class="nav-link" href="${ urlRoot }logout">Cerrar Sesión</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<br>
	${ menuCompleto }
	
	<!-- Datos del usuario -->
	<div class="container marketing">
		<div style="text-align:right; ">
			Bienvenido(a) ${ usuarioAuth.nombre } ${ usuarioAuth.apellidos }
		</div>
		<div style="text-align:right; ">
			
		</div>
	</div>
	