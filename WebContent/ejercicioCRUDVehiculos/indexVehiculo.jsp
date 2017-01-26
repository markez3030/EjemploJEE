<%@page
	import="com.ipartek.formacion.ejercicioVehiculo.services.VehiculoDao"%>
<%@ include file="/layout/header.jsp"%>

<div class="container">
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
			Ejercicio que muestra por pantalla un listado de coches. <br />En
			este ejercicio vamos a realizar las siguientes operaciones <br>
			<strong><em>Crear coche</em></strong> <br> <strong><em>Eliminar
					coche</em></strong> <br> <strong><em>Mostrar coche</em></strong> <br> <strong><em>Modificar
					coche</em></strong><br /> <br />
		</p>
		<table id="example" class="display" width="100%" cellspacing="0"">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Modelo</th>
					<th>Plazas</th>
					<th>Dimension</th>
					<th>CVV</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="v" items="${vehiculos}">
					<tr>
						<td><a href="ejercicioCRUDVehiculo/vehiculo?op=2&id=${v.id}">${v.id}</a></td>
						<td>${v.modelo}</td>
						<td>${v.plazas}</td>
						<td>${v.dimensiones}</td>
						<td>${v.potencia}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<article id="impresionDatos2">
			<c:set var="user" value="${sessionScope.user}" />
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:if test="${user==null}">
				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>No hay usuario logueado!!!</strong>${error}<br /> <strong><em>Total
							Vehiculos:</em></strong> ${fn:length(vehiculos)}<br /> <strong><em>Fecha:
					</em></strong>
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" />
				</div>
			</c:if>
			<c:if test="${user!=null}">
				<div class="alert alert-success" role="alert">
					USUARIO: ${user}<br /> <strong><em>Total Vehiculos:</em></strong>
					${fn:length(vehiculos)}<br /> <strong><em>Fecha: </em></strong>
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" />
				</div>
			</c:if>

		</article>
	</div>
	<!--  <div class="row"> -->
</div>
<%@ include file="/layout/footer.jsp"%>