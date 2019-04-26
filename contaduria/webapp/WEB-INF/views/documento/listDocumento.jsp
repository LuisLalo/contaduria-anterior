<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>UABC | Contaduría</title>

<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/resources" var="urlResources"></spring:url>
<spring:url value="/documento/editar" var="urlEditar" />
<spring:url value="/documento/eliminar" var="urlEliminar" />

<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${ urlResources }/bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="${ urlResources }/bootstrap/css/glyphicons.css" rel="stylesheet">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>

	<br>
	<div class="container theme-showcase" role="main">

		<h3 class="text-center font-weight-bold">Documentos</h3>
		
	  <c:if test="${ mensaje!=null }">
      	<div class="alert alert-success" role="alert">${ mensaje }</div>
      </c:if>
      
		<a href="${ urlRoot }documento/crear" class="btn btn-success" role="button" title="Crear Nuevo Documento">Nuevo Documento</a> 
		<a href="${ urlRoot }documento/nuevo" class="btn btn-success" role="button" title="Crear Nuevo Documento">Nuevo Documento Informe</a>
			<br>
			<br>
			<br>


		<div style="align-content: center;">
			<div class="row">
				<div class="col-sm-4">

					<form action="${urlRoot}documento/busqueda" method="get">

						<div class="input-group">

							<input type="text" class="form-control"
								aria-label="Text input with dropdown button" name="nombre" />
							<div class="input-group-append">

								<button type="submit" class="btn btn-outline-secondary"
									aria-haspopup="true" aria-expanded="false">Buscar</button>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<br>



		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>No. Documento</th>
					<th>Nombre</th>
					<th>Sección</th>
					<th>Tipo</th>
					<th>Acciones</th>
				</tr>
				<c:forEach items="${ documentos }" var="documentos">
					<tr>
						<td>${ documentos.iddocumento }</td>
						<td><a href="${urlResources}/${documentos.liga}">${ documentos.nombre }
						</a></td>
						<td>${documentos.idventana }</td>



						<c:choose>
							<c:when test="${ documentos.idtipodocumento eq '1' }">
								<td><span class="fa fa-file-word-o" style="color: blue"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '2' }">
								<td><span class="fa fa-file-excel-o" style="color: green"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '3' }">
								<td><span class="fa fa-file-pdf-o" style="color: red"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '4' }">
								<td><span class="fa fa-file-word-o" style="color: blue"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '5' }">
								<td><span class="fa fa-file-excel-o" style="color: green"></span></td>
							</c:when>
						</c:choose>


						<c:choose>
							<c:when test="${ documentos.idtipodocumento eq '1' }">
								<td><a href="${ urlEditar }/${documentos.iddocumento}"
									class="btn btn-success btn-sm" role="button" title="Editar"><span
										class="glyphicon glyphicon-pencil"></span> <a
										href="${ urlEliminar }/${documentos.iddocumento}"
										onclick='return confirm("¿Estás seguro que deseas eliminar este documento?")'
										class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
											class="glyphicon glyphicon-trash"></span></a></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '2' }">
								<td><a href="${ urlEditar }/${documentos.iddocumento}"
									class="btn btn-success btn-sm" role="button" title="Editar"><span
										class="glyphicon glyphicon-pencil"></span> <a
										href="${ urlEliminar }/${documentos.iddocumento}"
										onclick='return confirm("¿Estás seguro que deseas eliminar este documento?")'
										class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
											class="glyphicon glyphicon-trash"></span></a></td>
							</c:when>
							<c:otherwise>
								<td><a href="${ urlEditar }/${documentos.iddocumento}"
									class="btn btn btn-success  btn-sm" role="button"
									title="Editar"><span class="glyphicon glyphicon-pencil"></span>
										<a href="${ urlEliminar }/${documentos.iddocumento}"
										onclick='return confirm("¿Estás seguro que deseas eliminar este documento?")'
										class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
											class="glyphicon glyphicon-trash"></span></a></td>
							</c:otherwise>
						</c:choose>

					</tr>
				</c:forEach>
			</table>
		</div>

		<hr class="featurette-divider">

	</div>
	<!-- /container -->

	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${urlResources}/bootstrap/js/popper.min.js"></script>
	<script src="${urlResources}/bootstrap/js/popper.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>