<%@page
	import="com.ipartek.formacion.ejercicioVehiculo.services.VehiculoDao"%>
<%@ include file="/layout/header.jsp"%>

<div class="container">
	<c:set var="user" value="${sessionScope.user}" />
	<div id="divLog">
		<c:if test="${user==null}">
			<a href="login?log=4" class="btn btn-info" role="button">Identificate</a>
		</c:if>
		<c:if test="${user!=null}">
			<a href="ejercicioLogin/logout?log=4" class="btn btn-danger"
				role="button">Cerrar Sesion: <strong>${fn:toUpperCase(user)}<strong></a>
		</c:if>
	</div>
	<div class="row">
		<div id="imagenGetPost">
			<img src="img/vehiculo.jpg" class="img-responsive img-rounded"
				alt="Cinque Terre">
		</div>
		<h2>
			<u>LISTADO DE COCHES</u>
		</h2>
		<br>
		<p>
			Ejercicio que muestra por pantalla un listado de coches sacado de una BBDD. <br />
			 Nombre de la base de datos: <strong><em>concesionario</em></strong><br /> 
			 <br /> Mapping del Servlet:<b>/ejercicioVehiculoBBDD/vehiculo</b><br />
		</p>
		<article id="impresionDatos">

			<%
				if (request.getAttribute("exito") != null) {
			%>
			<div class="alert alert-success" role="alert">${exito}</div>
			<%
				}
			%>
		</article>
		<c:if test="${user!=null}">
			<a href="ejercicioVehiculoBBDD/vehiculo?op=3" class="btn btn-success"
				role="button">Crear coche</a>
			<br />
			<br />
			<br />
		</c:if>
		<table id="example" class="display" width="100%" cellspacing="0"">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Modelo</th>
					<th>Plazas</th>
					<th>Dimension</th>
					<th>CVV</th>
					<c:if test="${user!=null}">
						<th>Eliminar</th>
						<th>Modificar</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="v" items="${listaVehiculo}">
					<tr>
						<td><a href="ejercicioVehiculoBBDD/vehiculo?op=6&id=${v.id}">${v.id}</a></td>
						<td>${v.modelo}</td>
						<td>${v.plazas}</td>
						<td>${v.dimensiones}</td>
						<td>${v.potencia}</td>
						<c:if test="${user!=null }">
							<th><a href="ejercicioVehiculoBBDD/vehiculo?op=4&id=${v.id}"><i
									class="fa fa-trash"
									onclick="return confirm('¿Seguro que quiere eliminar este coche?')"
									aria-hidden="true"></i></a></th>
							<th><a href="ejercicioVehiculoBBDD/vehiculo?op=6&id=${v.id}"><i
									class="fa fa-pencil-square" aria-hidden="true"></i> </a></th>

						</c:if>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<article id="impresionDatos2">

			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:if test="${user==null}">
				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>No hay usuario logueado!!!</strong>${error}<br /> <strong><em>Total
							Vehiculos:</em></strong> ${fn:length(listaVehiculo)}<br /> <strong><em>Fecha:
					</em></strong>
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" />
				</div>
			</c:if>
			<c:if test="${user!=null}">
				<div class="alert alert-success" role="alert">
					USUARIO: ${user}<br /> <strong><em>Total Vehiculos:</em></strong>
					${fn:length(listaVehiculo)}<br /> <strong><em>Fecha: </em></strong>
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" />
				</div>
			</c:if>



		</article>
		<div class="btnAtras">
			<a href="index.jsp"><i class="fa fa-chevron-circle-left fa-5x"
				title="Atras" aria-hidden="true"></i> </a>
		</div>
	</div>
	<!--  <div class="row"> -->
</div>
<%@ include file="/layout/footer.jsp"%>