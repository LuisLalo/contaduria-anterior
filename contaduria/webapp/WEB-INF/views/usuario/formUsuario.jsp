<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
	<title>UABC | Contaduría</title>

<spring:url value="/resources" var="urlResources"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/usuario/guardar" var="urlForm"></spring:url>
<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>
	
	<jsp:include page="../includes/header.jsp"></jsp:include>
    
	<div class="container">
		
		<br>
		<h3 class="text-center font-weight-bold">Datos del Usuario</h3>
		<br>
		 		
	<spring:hasBindErrors name="Usuario">
	
		<div class="alert alert-danger" role="alert">
			Por favor corrija los siguientes errores:
			<ul>
				<c:forEach var="error" items="${ errors.allErrors }">
					<li><spring:message message="${ error }" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

      <form:form action="${ urlForm }" method="post" enctype="multipart/form-data" modelAttribute="usuario">
        <div class="row">
          <div class="col-sm-2">
            <div class="form-group">
              <label for="numero empleado">Número de Empleado</label>
              <form:input type="text" class="form-control" path="idUsuario"  id="idUsuario" required="required" />
            </div>  
          </div>
          
          <div class="col-sm-3">
            <div class="form-group">
              <label for="nombres">Nombres</label>
              <form:input type="text" class="form-control" path="nombre" id="nombre" required="required" />
            </div>  
          </div>
          
          <div class="col-sm-3">
            <div class="form-group">
              <label for="apellidos">Apellidos</label>
              <form:input type="text" class="form-control" path="apellidos" id="apellidos" required="required" />
            </div>  
          </div>
          <div class="col-sm-4">
            <div class="form-group">
              <label for="correos">Correo</label>
              <form:input type="email" class="form-control" path="correo" id="correo" required="required" />
            </div>  
          </div>
		</div>
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="contrasena">Contraseña</label>
              <form:input type="password" class="form-control" path="password" id="password" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="puesto" class="control-label">Tipo usuario</label>              
              <form:select id="idTipoUsuario" path="idTipoUsuario" class="form-control"  >
                <c:forEach var="tipoUsuario" items="${ tipoUsuario }">
                	<form:option value="${ tipoUsuario.idTipoUsuario }">${ tipoUsuario.tipo }</form:option>
                </c:forEach>
              </form:select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="departamento" class="control-label">Dependencia</label>              
              <form:select id="idDependencia" path="idDependencia" class="form-control" >
                <c:forEach var="dependencia" items="${ dependencia }">
                	<form:option value="${ dependencia.idDependencia }">${ dependencia.dependencia } - ${ dependencia.campus }</form:option>
                </c:forEach>
              </form:select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus" class="control-label">Estatus</label>              
              <form:select id="idEstatus" path="idEstatus" class="form-control" >
                 <c:forEach var="estatus" items="${ estatus }">
                	<form:option value="${ estatus.idEstatus }">${ estatus.estatus }</form:option>
                </c:forEach>               
              </form:select>             
            </div> 
          </div>
        </div>
        <button type="submit" class="btn btn-success" >Guardar</button>
      </form:form> 
		
		</div>
	
	    <jsp:include page="../includes/footer.jsp"></jsp:include>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>