<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--  Línea para agregar los íconos de las acciones-->
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<spring:url value="/tipoDocumento/editar" var="urlEditar" />
    <spring:url value="/tipoDocumento/eliminar" var="urlEliminar" />
    
    
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

<br>

<div class="container">

    <div class="container theme-showcase" role="main">

      <h3 class="text-center font-weight-bold">Listado de Tipos de Documentos</h3>
      
      <c:if test="${ mensaje!=null }">
      	<div class="alert alert-success" role="alert">${ mensaje }</div>
      </c:if>
      
      <a href="${ urlRoot }tipoDocumento/crear" class="btn btn-success" role="button" title="Nuevo Tipo de Documento" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Extensión</th>
                <th>Acciones</th>
            </tr>
            <c:forEach items="${ tipoDocumento }" var="tipoDocumento">
            <tr>
                <td>${ tipoDocumento.idTipoDocumento }</td>
                <td>${ tipoDocumento.icono }</td>
                <td>${ tipoDocumento.documento }</td>
                <td>
                    <a href="${ urlRoot }tipoDocumento/editar/${ tipoDocumento.idTipoDocumento }" class="btn btn-success btn-sm" role="button" title="Editar" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${ urlRoot }tipoDocumento/eliminar/${ tipoDocumento.idTipoDocumento }" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
            </c:forEach>
        </table>
      </div>
</div>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>
