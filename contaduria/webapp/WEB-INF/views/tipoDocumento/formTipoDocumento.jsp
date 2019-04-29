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
<spring:url value="/tipoDocumento/guardar" var="urlForm"></spring:url>
<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>
	
	<jsp:include page="../includes/header.jsp"></jsp:include>
    
	<div class="container">
		
		<br>
		<h3 class="text-center font-weight-bold">Datos del Tipo de Documento</h3>
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

      <form:form action="${ urlForm }" method="post" enctype="multipart/form-data" modelAttribute="tipoDocumento">
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <form:hidden path="idTipoDocumento"/>
              <form:input type="text" class="form-control" path="icono" id="icono" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="extension">Extensión</label>
              <form:input type="text" class="form-control" path="documento" id="documento" required="required" />
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