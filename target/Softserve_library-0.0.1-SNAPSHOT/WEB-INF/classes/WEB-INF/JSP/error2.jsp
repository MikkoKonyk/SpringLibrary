<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/JSP/includes.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>ERROR</title>
<style>
h1 {
	font: bold 2.5em "Times New Roman", Times, serif;
	background-color: red;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background:;
}
</style>
</head>
<body>
	<h1 align="center">THIS USER ALREADY HAS ONE COPY OF THIS BOOK!!!
		HE IS NOT ALLOWED TO TAKE IT TWICE !!!</h1>
	<div align="center">
		<button id="HOME" type="button"
			onclick="location.href='/Softserve_library/home'" value="Home"
			class="btn btn-success btn-lg">
			<span class="glyphicon glyphicon-hand-left"></span>HOME
		</button>
	</div>
	<br>
	<br>
	<div align="center">
		<button id="HOME" type="button"
			onclick="location.href='/Softserve_library/storage'" value="storage"
			class="btn btn-primary btn-lg">
			<span class="glyphicon glyphicon-book"></span>BOOK REGISTRY
		</button>
	</div>
	<br>
	<br>
	<div align="center">
		<button id="HOME" type="button"
			onclick="location.href='/Softserve_library/reader'" value="Readers"
			class="btn btn-warning btn-lg">
			<span class="glyphicon glyphicon-user"></span>READERS
		</button>
	</div>
</body>
</html>