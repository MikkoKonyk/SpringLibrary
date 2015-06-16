<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/JSP/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">

.bs-example {
	margin: 10px; # HOME { width : 200px;
	height: 150px;
	font-size: 30px; table , th, tr, td { border : 1px;
	border-style: solid;
	border-color: #8AC007;
	border-radius: 3px;
}
body {
 background: #FFDCA6;
}

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
  background-color: #00FF00;
}
</style>
<title>BOOKS</title>
</head>
	<body>
	<nav class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="/Softserve_library/home">Home</a></li>
              <li><a href="/Softserve_library/bookDto">Books&Authors</a></li>
              <li><a href="/Softserve_library/autor">Authors</a></li>
              <li><a href="/Softserve_library/reader">Readers</a></li>
              <li><a href="/Softserve_library/storage">Storage</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </nav>
      
	<c:if test="${!empty book.bookId}">
	<c:url var="addAction" value="/book/add"></c:url>
	<form:form action="${addAction}" method="POST" commandName="book">
		<div class="bs-example">
			<table class="table table-hover">
				
				<tr>
						<form:hidden path="bookId" />
				</tr>
				<tr>
					<td>Book name</td>
					<td><form:input path="bookName" /></td>
				</tr>
				<tr>
					<td>Book edition</td>
					<td><form:input path="edition" /></td>
				</tr>
				<tr>
					<td>Year printed</td>
					<td><form:input path="year" /></td>
				</tr>
				<tr>
					<td>Number of pages</td>
					<td><form:input path="pages" /></td>
				</tr>
				<tr>
					<td>Number of copies</td>
					<td><form:input path="numberOfCopies" /></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" class="btn btn-primary btn-sm" value="<spring:message text="Edit Book"/>" />
					<td>
						<button type="button" onclick="location.href='/Softserve_library/book'"	
						class="btn btn-danger btn-sm" value="Storage">
							Cancel<span class="glyphicon glyphicon-remove-circle"></span>
						</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
	</c:if>
	<h1 align="center">View book details</h1>
	<div class="bs-example">
		<table class="table table-hover table-nonfluid">
			<tr>
				<th>ID</th>
				<th>Book name</th>
				<th>Book edition</th>
				<th>Number of pages</th>
				<th>Year printed</th>
				<th>Number of copies</th>
				<th>Edit</th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.bookName}</td>
					<td>${book.edition}</td>
					<td>${book.year}</td>
					<td>${book.pages}</td>
					<td>${book.numberOfCopies}</td>
					<td><a href="/Softserve_library/book/edit/${book.bookId}" class="btn btn-primary btn-xs btn-block"><span class="glyphicon glyphicon-pencil"></span>Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>