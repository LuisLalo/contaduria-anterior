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
<spring:url value="/seccion/guardar" var="urlForm"></spring:url>
<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>
	
	<jsp:include page="../includes/header.jsp"></jsp:include>
    
	<div class="container">
		
		<br>
		<h3 class="text-center font-weight-bold">Datos de la Sección</h3>
		<br>
		 		
	<spring:hasBindErrors name="Seccion">
	
		<div class="alert alert-danger" role="alert">
			Por favor corrija los siguientes errores:
			<ul>
				<c:forEach var="error" items="${ errors.allErrors }">
					<li><spring:message message="${ error }" /></li>
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

      <form:form action="${ urlForm }" method="post" enctype="multipart/form-data" modelAttribute="ventana">
        <fieldset> <legend>Sección</legend>
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <form:hidden path="idVentana"/>
              <form:input type="text" class="form-control" path="nombre" id="nombre" required="required" />
            </div>  
          </div>
          
          <div class="col-sm-3">
            <div class="form-group">
              <label for="liga">liga</label>
              <form:input type="text" class="form-control" path="liga" id="liga" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="id nivel">Nivel</label>
              <form:input type="text" class="form-control" path="idNivel" id="idNivel" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus">Estatus</label>
              <form:input type="text" class="form-control" path="estatus" id="estatus" required="required" />
            </div>  
          </div>
        </div>
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="Orden" class="control-label">Orden</label>              
              <form:input type="text" class="form-control" path="orden" id="orden" required="required" />
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="idReferencia" class="control-label">idReferencia</label>              
              <form:input type="text" class="form-control" path="idReferencia" id="idReferencia" required="required" />             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="descripcion">Descripción</label>
              <form:input type="textarea" class="form-control" path="descripcion" id="descripcion" />
            </div>  
          </div>
        </div>
        </fieldset>
        <fieldset> <legend>Responsable</legend>
        <div class="row">
        
          <div class="col-sm-3">
            <div class="form-group">
              <label for="responsable">Nombre</label>
              <form:input type="text" class="form-control" path="responsable" id="responsable" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="correo">correo</label>
              <form:input type="email" class="form-control" path="correo" id="correo" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="extension">Extensión</label>
              <form:input type="text" class="form-control" path="extension" id="extension" />
            </div>  
          </div>
        </div>
        </fieldset>
        
        <button type="submit" class="btn btn-success" >Guardar</button>
      </form:form> 
		
		</div>
	
	    <jsp:include page="../includes/footer.jsp"></jsp:include>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="${ urlResources }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ urlResources }/bootstrap/js/bootstrap-4-navbar.js"></script>

</body>
</html>