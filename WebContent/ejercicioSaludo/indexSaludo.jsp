<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Primer Ejemplo Controlado</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="../css/freelancer.min.css" rel="stylesheet">

<!-- Custom -->
<link href="../css/custom.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<section> 
		<article >
	<div id="imagenGetPost">
	 <img src="../img/getPost.jpg" class="img-responsive img-rounded" alt="Cinque Terre"> 
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
		href="saludo?nombre=Egoitz&apellido1=Marquez&apellido2=Calvo">Llamada
			Get</a></strong></article> <article class="anchuraDivIndex">
	<h4>Peticion POST realizado con un formulario</h4>
	<form action="saludo" method="POST">
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
	</article> <article> 
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

			out.println("<p><b>Segundo apellido:</b> " + request.getParameter("apellido2")+"</p>");
			}
	%>


	</article> </section>


</body>
</html>