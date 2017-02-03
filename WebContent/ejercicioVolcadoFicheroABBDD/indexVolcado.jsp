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
			<u>RESUMEN DE VOLCADO</u>
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
			<article>
			<a href="${ficheroIncorrecto}">FicheroIncorrecto.txt</a>
			<p>Archivo incorrecto: ${ficheroIncorrecto}</p>
			<p>Transacciones correctas: ${registrosCorrectos}</p>
			<p>Transacciones incorrectas: ${registrosIncorrectos}</p>
			<p>Tiempo: ${tiempo} seg. </p>
			</article>
		<div class="btnAtras">
			<a href="index.jsp"><i class="fa fa-chevron-circle-left fa-5x"
				title="Atras" aria-hidden="true"></i> </a>
		</div>
	</div>
	<!--  <div class="row"> -->
</div>
<%@ include file="/layout/footer.jsp"%>