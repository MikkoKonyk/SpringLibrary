<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/JSP/includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

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
				$('.romko').prop("required", true);
				$('#storage').submit(
						function() {

							var dateTakenElem = $('#dateTaken');
							var date1 = $.trim(dateTakenElem.val());
							var isNumber1 = /^[+-]?\d*(\.\d+)?$/.test(date1);

							var dateToReturnElem = $('#dateToReturn');
							var date2 = dateToReturnElem.val();
							var isNumber2 = /^[+-]?\d*(\.\d+)?$/.test(date2);

							var resultDate1 = toggleError(dateTakenElem,
									isNumber1, 'Value should be numeric');

							var resultDate2 = toggleError(dateToReturnElem,
									isNumber2, 'Value should be numeric');

							return resultDate1 && resultDate2;
						});
			});
</script>
<style>
.error {
	border: 2px solid red;
}

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
	background-color: #00FF00;
}

.input-mini {
	width: 60px;
}

.input-small {
	width: 90px;
}

.input-medium {
	width: 150px;
}

.input-large {
	width: 210px;
}

.input-xlarge {
	width: 270px;
}

.input-xxlarge {
	width: 530px;
}

#toolbar .wrapper {
	text-align: center;
}
</style>

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
				<li><a href="/Softserve_library/bookDto">Books&Authors</a></li>
				<li><a href="/Softserve_library/book">Books</a></li>
				<li><a href="/Softserve_library/autor">Authors</a></li>
				<li><a href="/Softserve_library/reader">Readers</a></li>
			</ul>
		</div>
	 </div>
	</nav>


	<c:if test="${!empty storage.copyId}">
		<c:url var="addAction" value="/storage/edit"></c:url>
		<form:form action="${addAction}" method="POST" commandName="storage">
		<h4>Select reader</h4>
			<select name="reader.readerId" onselect="reader"
				class="form-control input-medium">
				<c:forEach items="${readerList}" var="reader">
					<option value="${reader.readerId}">${reader.readerId}---${reader.readerName}</option>
				</c:forEach>
			</select>
			<br>
			<h4>Available: </h4>
			<form:radiobutton path="available"  value="YES" />YES
				<form:radiobutton path="available" value="NO" />NO<br>
			<table>
				<tr>
					<form:hidden path="copyId" />
				</tr>
				<tr>
					<form:hidden path="book.bookId" />
				</tr>
				<tr>
					<form:hidden path="book.bookName" />
				</tr>
				<tr>
					<td>Date taken </td>
					<td><form:input path="dateTaken"
							class="form-control input-medium" /></td>
				</tr>
				<tr>
					<td>Date to return </td>
					<td><form:input path="dateToReturn"
							class="form-control input-medium" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						class="btn btn-success btn-sm"
						value="<spring:message text="Edit entry"/>" /></td>
					<td>
						<button type="button"
							onclick="location.href='/Softserve_library/storage'"
							class="btn btn-danger btn-sm" value="Storage">
							Cancel<span class="glyphicon glyphicon-remove-circle"></span>
						</button>
					</td>
				</tr>
			</table>
		</form:form>
	</c:if>

	<h1  align="center">Registry of all books</h1>
	<div>
		<table class="table table-hover table-nonfluid">
			<tr>
				<th style="width: 10%">Copy ID</th>
				<th style="width: 10%">Avaliable</th>
				<th style="width: 10%">Date taken</th>
				<th style="width: 10%">Date to return</th>
				<th style="width: 10%">Book Id</th>
				<th style="width: 10%">Book name</th>
				<th style="width: 10%">Reader Id</th>
				<th style="width: 10%">Reader name</th>
				<th style="width: 10%">Edit</th>
			</tr>
			<c:forEach items="${storageList}" var="storage">
				<tr>
					<td>${storage.copyId}</td>
					<td>${storage.available}</td>
					<td>${storage.dateTaken}</td>
					<td>${storage.dateToReturn}</td>
					<td>${storage.book.bookId}</td>
					<td>${storage.book.bookName}</td>
					<td>${storage.reader.getReaderId()}</td>
					<td>${storage.reader.getReaderName()}</td>


					<c:if test="${!empty storage.dateTaken}">
						<td><a href="/Softserve_library/storage/return/${storage.copyId}"
							class="btn btn-primary btn-xs btn-block"><span
								class="glyphicon glyphicon-hand-left"></span>Return book</a></td>
					</c:if>
					<c:if test="${empty storage.dateTaken}">
						<td><a href="/Softserve_library/storage/issue/${storage.copyId}"
							class="btn btn-success btn-xs btn-block"><span
								class="glyphicon glyphicon-book"></span>Issue book</a></td>
					</c:if>
			</c:forEach>
		</table>

	</div>
</body>
</html>