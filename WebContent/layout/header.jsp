<%@page import="com.ipartek.formacion.ejercicioVehiculo.pojo.Vehiculo"%>
<%@page import="com.ipartek.formacion.ejecicioReceta.pojo.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page session="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<base href="/EjemploJEE/">
<title>Primer Ejemplo Controlado</title>

<!-- Bootstrap Core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- JQUERY -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- DATABASE -->
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="//cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"></script>


<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">

<link href="css/custom.css" rel="stylesheet">

<!-- Custom -->
<link href="css/error.css" rel="stylesheet">

<!-- Login -->
<link href="css/login.css" rel="stylesheet">

<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
<script type="text/javascript">
    $(document).ready(function() {
        $('#example').dataTable( {
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Spanish.json"
            }
        } );
    } );
</script>


 <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

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


