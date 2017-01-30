<%@ include file="/layout/header.jsp"%>

<section>
	<article>
		<div id="imagenGetPost">
			<img src="img/vehiculo.jpg" class="img-responsive img-rounded"
				alt="Cinque Terre">
		</div>
	</article>
	<article>
		<h1>Ejercicio Fichero</h1>
		<p>
			Ejercicio para crear un fichero de texto, usaremos un
			<code>Stream</code>
			<br /> tipo
			<code>FileWriter</code>
			<br /> Acordarse de usar un
			<code>Buffer </code>
			del tipo
			<code>BufferedWriter</code>
			para mejorar la escritura<br /> <b>Capitulo 10, pag 158</b> <br />
			Mapping del Servlet:<b>/ejercicioFichero/fichero</b><br />
		</p>
	</article>

	<article id="impresionDatos">
		<%
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
			} else if (request.getAttribute("exito") != null) {
		%>
		<div class="alert alert-success" role="alert">${exito}</div>
		<%
			}
		%>
	</article>
	<article class="anchuraDivIndex">
		<form action="ejercicioFichero/fichero" method="POST">
			<div class="form-group">
				<label for="nombre">Nombre fichero:</label> <input type="text"
					class="form-control" size="15" name="nombre" id="nombre"
					placeholder="Nombre fichero sin extension" required autofocus>
			</div>
			<div class="form-group">
				<label for="contenido">Descripcion</label>
				<textarea class="form-control" rows="5" name="contenido"
					id="contenido" required></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Crear fichero</button>
		</form>
	</article>

	<form action="ejercicioFichero/fichero" method="GET">
		<div class="form-group">
			<label for="nombre2">Nombre fichero:</label> <input type="text"
				class="form-control" size="15" name="nombre2" id="nombre2"
				placeholder="Nombre fichero sin extension" required autofocus>
		</div>
		<button type="submit" class="btn btn-primary">Leer fichero</button>
	</form>
	<div class="btnAtras">
		<a href="index.jsp"><i class="fa fa-chevron-circle-left fa-5x"
			title="Atras" aria-hidden="true"></i> </a>
	</div>

	<c:if test="${contenidoFichero!=null}">
	<div class="form-group">
		<label for="contenido">Fichero</label>
		<textarea class="form-control" rows="5" name="contenido"
			id="contenido">${contenidoFichero}</textarea>
	</div>
	</c:if>


</section>

<%@ include file="/layout/footer.jsp"%>
