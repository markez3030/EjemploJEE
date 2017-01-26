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
		 Mapping del Servlet:<b>/ejercicioCRUDVehiculo/vehiculo</b><br />
	</p>
	<c:set var="v" value="${vehiculoDetalle}"/>
	
	<c:if test="${v==null }">
		<h1></h1>
	</c:if>
	
	<article class="anchuraDivIndex">
		<div class="form-group">
			<label for="modelo">Modelo</label> <input type="text"
				class="form-control" size="15" name="modelo" id="modelo"
				 value="<c:out value="${v.plazas}"></c:out>" readonly >
		</div>
		<div class="form-group">
			<label for="plazas">Plazas </label> <input type="number"
				class="form-control" name="plazas" id="plazas"
				 min="2"  readonly>
		</div>
		<div class="form-group">
			<label for="dimensiones">Dimensiones: </label> <input type="number"
				class="form-control" name="dimensiones" id="dimensiones"
				 readonly>
		</div>
		<div class="form-group">
			<label for="potencia">Potencia:</label> <input type="number"
				class="form-control" name="potencia" id="potencia"
				readonly>
		</div>
	</article> </section>
	
<%@ include file="/layout/footer.jsp" %>
