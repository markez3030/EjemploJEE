<%@ include file="/layout/header.jsp" %>

	<section> <article>
	<div id="imagenGetPost">
		<img src="img/vehiculo.jpg" class="img-responsive img-rounded"
			alt="Cinque Terre">
	</div>
	
	</article> <article>
	<h1>Ejercicio CRUD Vehiculo</h1>
	<p>
		Pagina en la que se muestra un vehiculo con los parametros: <br />
		<strong><em>modelo,plazas,potencia y dimensiones.</em>
		<br/>Estos parametros son modificables
		Mapping del Servlet:<b>/ejercicioCRUDVehiculo/vehiculo?op=6</b><br />
	</p>
	<c:set var="v" value="${vehiculoDetalle}"/>

	<article class="anchuraDivVerVehiculo">
		<form action="ejercicioVehiculoBBDD/vehiculo?op=7" method="POST">
		<div class="form-group">
			<label for="modelo">Identificador</label> <input type="text"
				class="form-control" size="15" name="id" id="id"
				 value="<c:out value="${v.id}"></c:out>"  readonly >
		</div>
		<div class="form-group">
			<label for="modelo">Modelo</label> <input type="text"
				class="form-control" size="15" name="modelo" id="modelo"
				 value="<c:out value="${v.modelo}"></c:out>"  >
		</div>
		<div class="form-group">
			<label for="plazas">Plazas </label> <input type="number"
				class="form-control" name="plazas" id="plazas"
				 min="2"  value="${v.plazas}" >
		</div>
		<div class="form-group">
			<label for="dimensiones">Dimensiones: </label> <input type="number"
				class="form-control" name="dimensiones" id="dimensiones" value="${v.dimensiones}"
				 >
		</div>
		<div class="form-group">
			<label for="potencia">Potencia:</label> <input type="number"
				class="form-control" name="potencia" id="potencia" value="${v.potencia}"
				>
		</div>
			<article id="impresionDatos3"> <%
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
		<button type="submit" class="btn btn-primary">Modificar</button>
		</form>
	</article> 
				<div class="btnAtras">
			<a href="ejercicioCRUDVehiculo/vehiculo"><i
				class="fa fa-chevron-circle-left fa-5x" title="Atras" aria-hidden="true"></i> </a>
			</div>
	</section>
	
<%@ include file="/layout/footer.jsp" %>
