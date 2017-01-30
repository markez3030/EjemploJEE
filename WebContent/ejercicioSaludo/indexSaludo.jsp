<%@ include file="/layout/header.jsp"%>


<section>
	<article>
		<div id="imagenGetPost">
			<img src="img/getPost.jpg" class="img-responsive img-rounded"
				alt="Cinque Terre">
		</div>
	</article>
	<article>
		<h1>Mi Primer Controlador</h1>
		<p>
			Los <b>Controladores</b> en Java son <b>Servlets</b>.<br /> Un
			controlador se encarga de recibir <b>Request</b> del cliente y darle
			una <b>Response</b>.<br /> Puede recibir y retornar parametros.<br />

			Puede aceptar peticiones de tipo <b>GET</b> o <b>POST</b>.<br />

			Mapping del Servlet:<b>/ejercicioSaludo/saludo</b><br />
		</p>

	</article>

	<article>
		<h4>Petición GET a traves de un enlace</h4>
		<strong><a
			href="ejercicioSaludo/saludo?nombre=Egoitz&apellido1=Marquez&apellido2=Calvo">Llamada
				Get</a></strong>
	</article>
	<article class="anchuraDivIndex">
		<h4>Peticion POST realizado con un formulario</h4>
		<form action="ejercicioSaludo/saludo" method="POST">
			<div class="form-group">
				<label for="Nombre">Nombre</label> <input type="text"
					class="form-control" name="nombre" id="nombre"
					placeholder="Introduzca el nombre">
			</div>
			<div class="form-group">
				<label for="apellido1">Apellido1 </label> <input type="text"
					class="form-control" name="apellido1" id="apellido1"
					placeholder="Introduzca el primer apellido">
			</div>
			<div class="form-group">
				<label for="apellido2">Segundo Apellido: </label> <input type="text"
					class="form-control" name="apellido2" id="apellido2"
					placeholder="Introduzca el segundo apellido">
			</div>

			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>
	</article>
	<article>
		<%
			if (request.getAttribute("nombre") != null) {
				out.println("<p><b>Nombre:</b> " + request.getParameter("nombre") + "</p>");
			}
		%>

		<%
			if (request.getAttribute("apellido1") != null)
				out.println("<p><b>Primer apellido:</b> " + request.getParameter("apellido1") + "</p>");
		%>

		<%
			if (request.getAttribute("apellido2") != null) {

				out.println("<p><b>Segundo apellido:</b> " + request.getParameter("apellido2") + "</p>");
			}
		%>


	</article>
</section>

<%@ include file="/layout/footer.jsp"%>
