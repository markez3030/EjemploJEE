<%@ include file="/layout/header.jsp"%>

<section>
	<article>
		<div id="imagenGetPost">
			<img src="img/vehiculo.jpg" class="img-responsive img-rounded"
				alt="Cinque Terre">
		</div>
	</article>
	<article>
		<h1>Ejercicio Vehiculo</h1>
		<p>
			Ejercicio en el que se crea un vehiculo con los parametros: <br /> <strong><em>modelo,plazas,potencia
					y dimensiones.</em></strong><br /> Si el vehiculo tiene la potencia, la
			dimension o las plazas<strong> negativas</strong>,<br /> No se
			creara el vehiculo y se mostrara <strong>un mensaje de error</strong><br />
			Si esta todo <strong>bien</strong>, se <strong>crea el
				vehiculo</strong> y se muestra por pantalla.<br /> Mapping del Servlet:<b>/ejercicioVehiculo/vehiculo?op=3</b><br />
		</p>
	<article id="impresionDatos"> <%
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

		<article class="anchuraDivIndex">
			<form action="ejercicioCRUDVehiculoFichero/vehiculo?op=5" method="POST">
				<div class="form-group">
					<label for="modelo">Modelo</label> <input type="text"
						class="form-control" size="15" name="modelo" id="modelo"
						placeholder="Introduzca el modelo" required pattern=".{2-255}">
				</div>
				<div class="form-group">
					<label for="plazas">Plazas </label> <input type="number"
						class="form-control" name="plazas" id="plazas"
						placeholder="Introduzca las plazas" min="2" required>
				</div>
				<div class="form-group">
					<label for="dimensiones">Dimensiones: </label> <input type="number"
						class="form-control" name="dimensiones" id="dimensiones"
						placeholder="Introduzca las dimensiones" required>
				</div>
				<div class="form-group">
					<label for="potencia">Potencia:</label> <input type="number"
						class="form-control" name="potencia" id="potencia"
						placeholder="Introduzca la potencia" required>
				</div>
				<button type="submit" class="btn btn-primary">Crear</button>
			</form>
		</article>
		<div class="btnAtras">
			<a href="ejercicioCRUDVehiculo/vehiculo"><i
				class="fa fa-chevron-circle-left fa-5x" title="Atras"
				aria-hidden="true"></i> </a>
		</div>
</section>

<%@ include file="/layout/footer.jsp"%>
