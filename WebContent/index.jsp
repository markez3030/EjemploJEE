<%@page import="com.ipartek.formacion.ejecicioReceta.pojo.Ingrediente"%>
<%@page import="com.ipartek.formacion.ejecicioReceta.pojo.Receta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/estiloMenu.css">
<title>Insert title here</title>
</head>
<body>
	<%
	Receta receta = new Receta("MARMITAKO", 30, "Sencilla", "4-6 personas",
			"Retira el rabo y las pepitas a los pimientos choriceros y ponlos a hidratar en un cuenco con agua caliente.");
	receta.setImagen("http://www.marmitako.net/ImagenesMarmitako/ImagenesMarmitako/Marmitakodesalmon.jpg");
	
	Receta receta2 = new Receta("Solomillo", 30, "Sencilla", "4-6 personas",
			"Retira el rabo y las pepitas a los pimientos choriceros y ponlos a hidratar en un cuenco con agua caliente.");
	receta2.setImagen("http://www.yrecetas.com/wp-content/uploads/2015/10/dsc_0052-carne-roja-solomillo-plancha.jpg");

	Receta receta3 = new Receta("Goxua", 30, "Sencilla", "4-6 personas",
			"Retira el rabo y las pepitas a los pimientos choriceros y ponlos a hidratar en un cuenco con agua caliente.");
	receta3.setImagen("http://www.hogarmania.com/archivos/201403/1420-goxua-604-xl-668x400x80xX.jpg?1");

	%>

	<h1>Menú del dia 10€</h1>

	
	<ul>

		<li><div>1.-Marmitako<br/><img src="<%=receta.getImagen()%>"></div></li>
		<li>2.-Solomillo<img src="<%=receta2.getImagen()%>"></li>
		<li>Postre: Goxua<img src="<%=receta3.getImagen()%>"></li>
		<li><i><b>Pan y vino incluidos</b></i></li>

	</ul>


</body>
</html>