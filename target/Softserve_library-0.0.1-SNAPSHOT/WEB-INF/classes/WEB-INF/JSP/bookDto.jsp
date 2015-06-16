<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/JSP/includes.jsp"%>
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
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				function toggleError(element, valid, message) {
					if (valid) {
						element.removeClass('error');
						element.after('');
						return true;
					} else {
						element.addClass('error');
						element.after(message);
						return false;
					}
				}
				
				$('#bookDto').submit(
						function() {
							var yearElem = $('#bookYearDto');
							var year = yearElem.val();
							var isNumber = /^[+-]?\d*(\.\d+)?$/.test(year);

							var bookNameElem = $('#bookNameDto');
							var bookName = $.trim(bookNameElem.val());
							
							var autorNameElem = $('#autorNameDto');
							var autorName = $.trim(autorNameElem.val());
							
							var autorSurNameElem = $('#autorSurnameDto');
							var autorSurName = $.trim(autorSurNameElem.val());

							var copiesElem = $('#booknumberOfCoopies');
							var copies = copiesElem.val();
							var isCopyNumber = /^[+-]?\d*(\.\d+)?$/.test(copies);

							var resultYear = toggleError(yearElem, isNumber, 'Value should be numeric');
							
							var resultName = toggleError(bookNameElem, bookName, 'Value should not be empty');
							
							var resultNameAutor = toggleError(autorNameElem, autorName, 'Value should not be empty');
							
							var resultSurNameAutor = toggleError(autorSurNameElem, autorSurName, 'Value should not be empty');
							
							var resultCopies = toggleError(copiesElem, isCopyNumber, 'Value should be numeric');

							return resultYear && resultName && resultCopies && resultNameAutor && resultSurNameAutor;
						});
			});
</script>
<style>
.error {
	border: 2px solid red;
}

.bs-example {
	margin: 10px; # HOME { width : 200px;
	height: 150px;
	font-size: 30px; 
}

.table table-hover { 
	background-color: #00FF00;
}

body {
	background-color: #555555;
}
</style>
<title>BOOKS</title>
</head>
<body>
<nav class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Go up</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="/Softserve_library/home">Home</a></li>
              <li><a href="/Softserve_library/book">Books</a></li>
              <li><a href="/Softserve_library/autor">Autor</a></li>
              <li><a href="/Softserve_library/reader">Reader</a></li>
              <li><a href="/Softserve_library/storage">Storage</a></li>
            </ul>
          </div>
        </div>
      </nav>
	<br>
	<br>
	<c:url var="addAction" value="/bookDto/add"></c:url>
	<form:form action="${addAction}" method="POST" commandName="bookDto">
		<div class="bs-example">
			<table class="table table-hover table-nonfluid">
			<tr>
				<form:hidden path="bookIdDto" />
			</tr>
			<tr>
				<td>Book name</td>
				<td><form:input path="bookNameDto" /></td>
			</tr>
			<tr>
				<td>Book edition</td>
				<td><form:input path="bookEditionDto" /></td>
			</tr>
			<tr>
				<td>Year printed</td>
				<td><form:input path="bookYearDto" /></td>
			</tr>
			<tr>
				<td>Number of pages</td>
				<td><form:input path="bookPagesDto" /></td>
			</tr>
			<tr>
				<td>Number of copies</td>
				<td><form:input path="booknumberOfCoopies" /></td>
			</tr>
			<tr>
				<form:hidden path="autorIdDto" />
			</tr>
			<tr>
				<td>Author name</td>
				<td><form:input path="autorNameDto" /></td>
			</tr>
			<tr>
				<td>Author surname</td>
				<td><form:input path="autorSurnameDto" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty bookDto.bookNameDto}">
						<input type="submit" class="btn btn-success btn-sm" value="<spring:message text="Edit Entry"/>" />
					</c:if> <c:if test="${empty bookDto.bookNameDto}">
						<input type="submit" class="btn btn-primary btn-sm"value="<spring:message text="Add Entry"/>" />
					</c:if></td>
					
					<td>
						<button   type="button" onclick="location.href='/Softserve_library/bookDto'" value="Storage" class="btn btn-danger btn-sm" value="Storage">Cancel<span class="glyphicon glyphicon-remove-circle"></span></button>
		            </td>
			</tr>
		</table>
		</div>
	</form:form>
	<h1 align="center">Take a look at some books we have for you:</h1>
	<div class="bs-example">
			<table class="table table-hover table-nonfluid">
			<tr>
				<th>ID</th>
				<th>Book name</th>
				<th>Book edition</th>
				<th>Year printed</th>
				<th>Number of pages</th>
				<th>Number of copies</th>
				<th>Author name</th>
				<th>Author surname</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${bookDtoList}" var="bookDto">
				<tr>
					<td>${bookDto.bookIdDto}</td>
					<td>${bookDto.bookNameDto}</td>
					<td>${bookDto.bookEditionDto}</td>
					<td>${bookDto.bookYearDto}</td>
					<td>${bookDto.bookPagesDto}</td>
					<td>${bookDto.booknumberOfCoopies}</td>
					<td>${bookDto.autorNameDto}</td>
					<td>${bookDto.autorSurnameDto}</td>
					<td><a href="/Softserve_library/bookDto/edit/${bookDto.bookIdDto}" class="btn btn-primary btn-xs btn-block"><span
							class="glyphicon glyphicon-pencil"></span>Edit</a></td>
					<td><a href="/Softserve_library/bookDto/delete/${bookDto.bookIdDto}" class="btn btn-danger btn-xs btn-block"><span
							class="glyphicon glyphicon-minus"></span>Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>