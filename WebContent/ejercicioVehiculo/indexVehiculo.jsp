<%@page
	import="com.ipartek.formacion.ejercicioVehiculo.services.VehiculoDao"%>
<%@ include file="/layout/header.jsp"%>


<section>
		<div class="list-group">
		<%
			ArrayList<Vehiculo> listVehiculo = (ArrayList<Vehiculo>) request.getAttribute("vehiculos");
			for (Vehiculo vehiculo : listVehiculo) {
		%>		
					<a href="#" class="list-group-item "> <%=vehiculo.getModelo() %>,<%=vehiculo.getId()%> </a>
					
			<%} %>

		</div>
</section>
<%@ include file="/layout/footer.jsp"%>