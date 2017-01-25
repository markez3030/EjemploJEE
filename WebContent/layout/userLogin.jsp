<strong>
<%
	if (session.getAttribute("user") == null) {
%>
<li class="list-group-item list-group-item-danger"><a
	href="ejercicioLogin/login.jsp">4.-Login (Sistema de logueo)</a></li>

<%
	} else {
%>
<li class="list-group-item list-group-item-danger"><a
	href="ejercicioLogin/logout">4.-Logout[X]</a><br/>Nombre: ${sessionScope.user}<br/>Avatar: <img src="<%=session.getAttribute("image") %>" class="img-rounded imagenUsuario " alt="Cinque Terre"></li>


<%
	}
%>
</strong>