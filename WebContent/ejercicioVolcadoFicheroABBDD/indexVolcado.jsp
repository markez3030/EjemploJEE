<%@page
	import="com.ipartek.formacion.ejercicioVehiculo.services.VehiculoDao"%>
<%@ include file="/layout/header.jsp"%>

<div class="container">
	<c:set var="lista" value="${listaPersonas}" />

	<c:set var="user" value="${sessionScope.user}" />
	<div id="divLog">
		<c:if test="${user==null}">
			<a href="login?log=5" class="btn btn-info" role="button">Identificate</a>
		</c:if>
		<c:if test="${user!=null}">
			<a href="ejercicioLogin/logout?log=5" class="btn btn-danger"
				role="button">Cerrar Sesion: <strong>${fn:toUpperCase(user)}<strong></a>
		</c:if>
	</div>
	<div class="row">
		<div id="imagenGetPost">
			<img src="img/migracion.jpg" class="img-responsive img-rounded"
				alt="Cinque Terre">
		</div>
		<h2>
			<u>MIGRACION DE UN .TXT A UNA BBDD</u>
		</h2>
		<br>
		<p>
			Ejercicio que migra un .txt a una base de datos. Se creara un .txt
			con los registros incorrectos<br /> Nombre de la base de datos: <strong><em>concesionario</em></strong><br />
			Nombre de la tabla: <strong><em>persona</em></strong><br /> <br />
			Mapping del Servlet:<b>/ejercicioVolcarDatos/volcarDatos</b><br />
		</p>
		<c:if test="${lista.isEmpty()}">
			<form action="ejercicioVolcarDatos/volcarDatos" method="POST">
				<button type="submit" class="btn btn-primary">Migrar Datos</button>
			</form>
		</c:if>
		<c:if test="${!lista.isEmpty()}">
			<a href="ejercicioVolcarDatos/volcarDatos?op=3"
				class="btn btn-danger" role="button">Borrar Registros</a>
			<article>
				<br /> <a href="ejercicioVolcarDatos/volcarDatos?op=2"
					class="btn btn-info" role="button">Ver registros</a>
				<c:if test="${ficheroIncorrecto!=null}">
					<br/><br/><a class="btn btn-success" role="button"
						href="${ficheroIncorrecto}"><strong><em>Registros incorrectos</em></strong></a>
				</c:if>
			</article>

		</c:if>

		<article id="impresionDatos2">
			<%
				if (request.getAttribute("exito") != null) {
			%>
			<div class="alert alert-success" role="alert">${exito}</div>
			<%
				}
				if (request.getAttribute("error") != null) {
			%>
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>Error!</strong>${error}
			</div>
			<%
				}
			%>
		</article>

		<br /> <br /> <br /> <br /> <br /> <br /> <br />
		<article>
			<c:if test="${listaPersonas!=null}">
				<table id="example" class="display" width="100%" cellspacing="0"">
					<thead>
						<tr>
							<th>#ID</th>
							<th>Nombre</th>
							<th>Apellido 1</th>
							<th>Apellido 2</th>
							<th>Edad</th>
							<th>Email</th>
							<th>DNI</th>
							<th>Puesto</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${listaPersonas}">
							<tr>
								<td>${p.id}</td>
								<td>${p.nombre}</td>
								<td>${p.apellido1}</td>
								<td>${p.apellido2}</td>
								<td>${p.edad}</td>
								<td>${p.email}</td>
								<td>${p.dni}</td>
								<td>${p.tipo}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:if>
		</article>
		<c:if test="${tiempo!=null }">
			<article>
				<p>
					<strong>RESUMEN MIGRACION</strong>
				</p>
				<hr>
				<p>
					<strong>Transacciones correctas:</strong> ${registrosCorrectos}
				</p>
				<p>
					<strong>Transacciones incorrectas:</strong> ${registrosIncorrectos}
				</p>
				<p>
					<strong>Tiempo:</strong> ${tiempo} seg.
				</p>
			</article>
		</c:if>

		<div class="btnAtras">
			<a href="index.jsp"><i class="fa fa-chevron-circle-left fa-5x"
				title="Atras" aria-hidden="true"></i> </a>
		</div>
	</div>
	<!--  <div class="row"> -->
</div>
<%@ include file="/layout/footer.jsp"%>