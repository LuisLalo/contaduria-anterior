<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>UABC | Documentos</title>

<spring:url value="/resources" var="urlResources"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/cierre/guardar" var="urlForm"></spring:url>
<link rel="stylesheet"
	href="${ urlResources }/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>

<body>

	<jsp:include page="../includes/header.jsp"></jsp:include>

	<div class="container">

		<br>
		<h3 class="text-center font-weight-bold">Datos del Documento</h3>
		<br>

		<spring:hasBindErrors name="documento">
			<div class="alert alert-danger" role="alert">
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${ errors.allErrors }">
						<li><spring:message message="${ error }" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${ urlForm }" method="post"
			enctype="multipart/form-data" modelAttribute="documentoInforme">

			<form:hidden path="iddocumento" />

			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<form:input type="text" class="form-control" path="nombre"
							id="nombre" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">

						<label for="liga">Archivo</label>
						<form:hidden path="liga" />
						<input type="file" id="archivo" name="archivo" required="required" />
						<p class="help-block">Archivo del Documento</p>
					</div>
				</div>

				<div class="col-sm-2">
					<div class="form-group">
						<label for="ventana" class="control-label">Sección</label>
						<form:select id="ventana" path="idventana">
							
						</form:select>
					</div>
				</div>
						
			<form:hidden path="orden"/>
			<form:hidden path="idtipodocumento" />
			<form:hidden path="idInformes" />
			
			<div class="col-sm-3">
					<div class="form-group">
						<label for="ventana" class="control-label">Categoría</label>
						<form:select id="categoria" path="categoria">
							<c:forEach var="categoria" items="${ Categorias }">

										<form:option value="${ categoria.idcategoria }">${ categoria.nombre }</form:option>

							</c:forEach>
						</form:select>
					</div>
				</div>
			
			<div class="col-sm-2">
					<div class="form-group">
						<label  class="control-label">Año</label>
						<form:select id="anio" path="anio">
							
								<%--Anadir en el controlador respectivo un metodo para cargar el año actual y los años anteriores hasta el 2018--%>
										<form:option value="2019">2019</form:option>
										<form:option value="2018">2018</form:option>
										<form:option value="2017">2017</form:option>
										<form:option value="2016">2016</form:option>
										<form:option value="2015">2015</form:option>
										<form:option value="2014">2014</form:option>
										<form:option value="2013">2013</form:option>
										<form:option value="2012">2012</form:option>
										<form:option value="2011">2011</form:option>
										<form:option value="2010">2010</form:option>
										<form:option value="2009">2009</form:option>
										<form:option value="2008">2008</form:option>
							
						</form:select>
					</div>
				</div>
			
			<div class="col-sm-2">
					<div class="form-group">
						<label  class="control-label">Mes</label>
						<form:select id="mes" path="mes">
								
										<form:option value="12">Diciembre</form:option>
										<form:option value="11">Noviembre</form:option>
										<form:option value="10">Octubre</form:option>
										<form:option value="9">Septiembre</form:option>
										<form:option value="8">Agosto</form:option>
										<form:option value="7">Julio</form:option>
										<form:option value="6">Junio</form:option>
										<form:option value="5">Mayo</form:option>
										<form:option value="4">Abril</form:option>
										<form:option value="3">Marzo</form:option>
										<form:option value="2">Febrero</form:option>
										<form:option value="1">Enero</form:option>
							
						</form:select>
					</div>
				</div>
			</div> 

			<button type="submit" class="btn btn-success">Guardar</button>
			<br>
			<br>
		</form:form>

		<p id="demo"></p>
		<span id="mensaje"></span><br>

		<div class="table-responsive" id="result">
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
						<td>${ documentos.nombre }</td>
						<td>${documentos.idventana }</td>

						<c:choose>
							<c:when test="${ documentos.idtipodocumento eq '1' }">
								<td><span class="fa fa-file-excel-o"></span></td>
							</c:when>
							<c:when test="${ documentos.idtipodocumento eq '2' }">
								<td><span class="fa fa-file-word-o"></span></td>
							</c:when>
							<c:otherwise>
								<td><span class="fa fa-file-pdf-o"></span></td>
							</c:otherwise>
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

	</div>

	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlResources}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


</body>
</html>