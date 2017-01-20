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
	<article class="anchuraDivIndex">
	<h4>Peticion POST realizado con un formulario</h4>
	<form action="saludo" method="POST">
		<div class="form-group">
			<label for="precio">Precio</label> <input type="text"
				class="form-control" name="precio" id="precio"
				placeholder="Introduzca el precio en €">
		</div>
		<div class="form-group">
			<label for="iva">IVA </label> <input type="text"
				class="form-control" name="iva" id="iva"
				placeholder="Introduzca el iva a aplicar">
		</div>
		<div class="form-group">
			<label for="apellido2">Precio con IVA </label> 
			<input type="text" class="form-control" name="precioConIva"
			
			<%
				if(request.getAttribute("precioIVA")!=null)
					out.print("value='"+request.getAttribute("precioIVA")+"'");
			%>
			readonly/>
		</div>

		<button type="submit" class="btn btn-primary">Calcular</button>
	</form>
	</article></section>


</body>
</html>