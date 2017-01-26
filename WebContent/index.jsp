<%@ include file="/layout/header.jsp"%>

<h1>Listado de ejercicios</h1>
<div class="anchuraDivIndex">
	<ul class="list-group">
		<li class="list-group-item list-group-item-success"><a href="ejercicioReceta/indexReceta.jsp"><strong>1.-Ejercicio	Recetas&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Ejercicio receta que saca un men� del dia)</strong></a></li>
		<li class="list-group-item list-group-item-info"><a href="ejercicioSaludo/saludo"><strong>2.-Controlador o Servlet [GET y POST]</strong></a></li>
		<li class="list-group-item list-group-item-warning"><a href="ejercicioVehiculo/vehiculo"><strong>3.-Vehiculo (Se crea un vehiculo. Si el valor numerico es negativo lanza excepcion)</strong></a></li>
		<%@include file="layout/userLogin.jsp" %>
		<li class="list-group-item list-group-item-success"><a href="ejercicioXXX/pagina-no-existe-404.jsp"><strong>5.-Gestion de error 404</strong></a></li>
		<li class="list-group-item list-group-item-info"><a href="controladorException?p=1"><strong>6.-Gestion de error 500</strong></a></li>
		<li class="list-group-item list-group-item-warning"><a href="controladorException?p=2"><strong>7.-Gestion de error VehiculoException</strong></a></li>
		<li class="list-group-item list-group-item-danger"><a href="ejercicioCRUDVehiculo/vehiculo">8.-CRUD vehiculo</a></li>
	</ul>
</div>
<%@ include file="/layout/footer.jsp"%>