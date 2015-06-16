<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/JSP/includes.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.bs-example {
	margin: 10px; # HOME { width : 200px;
	height: 150px;
	font-size: 30px; table , th, tr, td { border : 1px;
	border-style: solid;
	border-color: #8AC007;
	border-radius: 3px;
}

body {
	background-color:;
}
</style>
<title>AUTORS</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/Softserve_library/home">Home</a></li>
				<li><a href="/Softserve_library/bookDto">Books&Authors</a></li>
				<li><a href="/Softserve_library/book">Books</a></li>
				<li><a href="/Softserve_library/reader">Readers</a></li>
				<li><a href="/Softserve_library/storage">Storage</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<h1 align="center">Edit authors</h1>
	<c:if test="${!empty autor.autorId}">
	<c:url var="addAction" value="/autor/add"></c:url>
	<form:form action="${addAction}" method="POST" commandName="autor">
		<div class="bs-example">
			<table class="table table-hover">
				<tr>
					<form:hidden path="autorId" />
				</tr>
				
				<tr>
					<td>Author name</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Author surname</td>
					<td><form:input path="surname" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="<spring:message text="Edit author"/>" /></td>
					<td>
						<button type="button"
							onclick="location.href='/Softserve_library/autor'"
							class="btn btn-danger btn-sm" value="Storage">
							Cancel<span class="glyphicon glyphicon-remove-circle"></span>
						</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
	</c:if>
	<h1 align="center">Authors of all available books</h1>
	<div class="bs-example">
		<table class="table table-hover">
			<tr>
				<th>Author ID</th>
				<th>Author name</th>
				<th>Authr surname</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${autorList}" var="autor">
				<tr>
					<td>${autor.autorId}</td>
					<td>${autor.name}</td>
					<td>${autor.surname}</td>
					<td><a href="/Softserve_library/autor/edit/${autor.autorId}"
						class="btn btn-primary btn-xs btn-block"><span
							class="glyphicon glyphicon-pencil"></span>edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>