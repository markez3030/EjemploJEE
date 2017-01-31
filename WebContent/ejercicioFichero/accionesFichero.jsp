<%@page
	import="com.ipartek.formacion.ejercicioFichero.controller.FicheroController"%>
<%@page import="java.io.File"%>
<%@ include file="/layout/header.jsp"%>

<section>
	<article>
		<div id="imagenGetPost">
			<img src="img/fichero.jpg" class="img-responsive img-rounded"
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
		<br>
	<p>ESCRIBIR EN FICHERO</p>
	<hr>
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


	<article>
		<p>LEER DEL FICHERO</p>
		<hr>


		<ul>
			<%
				//Buscar ficheros en PATH
				File ficheros = new File(FicheroController.PATH);
				File[] files = ficheros.listFiles();
				if (files.length > 0) {
					File f = null;
					for (int i = 0; i < files.length; i++) {
						f = files[i];
						if (!f.isDirectory()) {
			%>
			<li><a href="ejercicioFichero/fichero?nombre2=<%=f.getName()%>"><%=f.getName()%></a>
				(<%=f.length()%> bytes)</li>
			<%
				} //end if
					} //end for
				} else {
					out.print("<li>No existen ficheros creados todavia!!!</li>");
				}
			%>
		</ul>
	</article>
	<br>
	<br>

	<c:if test="${texto!=null}">
		<div class="form-group">
			<label for="contenido">Contenido</label>
			<textarea class="form-control" rows="5" name="contenido"
				id="contenido" readonly>${texto}</textarea>
		</div>
	</c:if>
	<%
		if (request.getAttribute("errorLectura") != null) {
	%>
	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Error!</strong>${errorLectura}
	</div>
	<%
		}
	%>

	<div class="btnAtras">
		<a href="index.jsp"><i class="fa fa-chevron-circle-left fa-5x"
			title="Atras" aria-hidden="true"></i> </a>
	</div>
</section>

<%@ include file="/layout/footer.jsp"%>
