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
	<title>UABC | Contadur�a</title>

	<spring:url value="/resources" var="urlResources"></spring:url>
	<spring:url value="/" var="urlRoot"></spring:url>
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!--  L�nea para agregar los �conos de las acciones-->
	<link rel="stylesheet" href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
	s
	
	
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<spring:url value="/seccion/editar" var="urlEditar" />
    <spring:url value="/seccion/eliminar" var="urlEliminar" />
    
    
</head>
<body>
	<jsp:include page="../includes/header.jsp"></jsp:include>

<br>

<div class="container">

    <div class="container theme-showcase" role="main">

      <h3 class="text-center font-weight-bold">Listado de Secciones</h3>
      
      <c:if test="${ mensaje!=null }">
      	<div class="alert alert-success" role="alert">${ mensaje }</div>
      </c:if>
      
      <a href="${ urlRoot }seccion/crear" class="btn btn-success" role="button" title="Nuevo Usuario" >Nuevo</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>liga</th>
                <th>Estatus</th>
                <th>Acciones</th>
            </tr>
            <c:forEach items="${ seccion }" var="seccion">
            <tr>
                <td>${ seccion.idVentana }</td>
                <td>${ seccion.nombre }</td>
                <td>${ seccion.liga }</td>
                
                <c:choose>
                <c:when test="${ seccion.estatus eq 'Activa'}">
                	<td><span class="badge badge-success">${ seccion.estatus }</span></td>
                </c:when>
                <c:otherwise>
                	<td><span class="badge badge-danger">${ seccion.estatus }</span></td>
                </c:otherwise>
                </c:choose>
                
                <td>
                    <a href="${ urlRoot }seccion/editar/${ seccion.idVentana }" class="btn btn-success btn-sm" role="button" title="Editar" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${ urlRoot }seccion/eliminar/${ seccion.idVentana }" class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
            </c:forEach>
        </table>
      </div>
</div>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="${ urlResources }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ urlResources }/bootstrap/js/bootstrap-4-navbar.js"></script>

</body>
</html>
