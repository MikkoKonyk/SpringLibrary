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
	$(document)
			.ready(
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

						$('#reader')
								.submit(
										function() {

											var readerNameElem = $('#readerName');
											var readerName = $
													.trim(readerNameElem.val());

											var readerSurnameElem = $('#readerSurname');
											var readerSurname = $
													.trim(readerSurnameElem
															.val());

											var readerBirthDateElem = $('#readerBirthDate');
											var date = readerBirthDateElem
													.val();
											var isNumber = /^[+-]?\d*(\.\d+)?$/
													.test(date);

											var resultName = toggleError(
													readerNameElem, readerName,
													'Value should not be empty');

											var resultSurname = toggleError(
													readerSurnameElem,
													readerSurname,
													'Value should not be empty');

											var resultBirthDay = toggleError(
													readerBirthDateElem,
													isNumber,
													'Value should be numeric');

											return resultName && resultSurname
													&& resultBirthDay;
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
	font-size: 30px; table , th, tr, td { border : 1px;
	border-style: solid;
	border-color: #8AC007;
	border-radius: 3px;
}

.table table-hover { 
	background-color: #00FF00;
}

body {
	background-color: #555555;
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
              <li><a href="/Softserve_library/storage">Storage</a></li>
            </ul>
          </div>
        </div>
      </nav>
	<c:url var="addAction" value="/reader/add"></c:url>
	<form:form action="${addAction}" method="POST" commandName="reader">
		<div class="bs-example">
			<table class="table table-hover">
				<tr>
					<form:hidden path="readerId"/>
				</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="readerName" /></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><form:input path="readerSurname" /></td>
			</tr>
			<tr>
				<td>Father's name</td>
				<td><form:input path="readerFatherName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="readerAddress" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="readerPhone" /></td>
			</tr>
			<tr>
				<td>Date of birth</td>
				<td><form:input path="readerBirthDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty reader.readerName}">
						<input type="submit"  class="btn btn-success btn-sm" value="<spring:message text="Edit reader"/>" />
					</c:if> <c:if test="${empty reader.readerName}">
						<input type="submit"  class="btn btn-primary btn-sm" value="<spring:message text="Add reader"/>" />
					</c:if></td>
				<td>
					<button type="button"
						onclick="location.href='/Softserve_library/reader'"
						value="Storage" class="btn btn-danger btn-sm" value="Storage">Cancel<span class="glyphicon glyphicon-remove-circle"></span></button>
				</td>
			</tr>
		</table>
		</div>
	</form:form>
	<h1 align="center">There are our readers:</h1>
	<div class="bs-example">
			<table class="table table-hover">
			<tr>
				<th>Reader ID</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Father's name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Date of birth</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${readerList}" var="reader">
				<tr>
					<td>${reader.readerId}</td>
					<td>${reader.readerName}</td>
					<td>${reader.readerSurname}</td>
					<td>${reader.readerFatherName}</td>
					<td>${reader.readerAddress}</td>
					<td>${reader.readerPhone}</td>
					<td>${reader.readerBirthDate}</td>
					<td><a href="/Softserve_library/reader/edit/${reader.readerId}" class="btn btn-primary btn-xs btn-block"><span
							class="glyphicon glyphicon-pencil"></span>Edit</a></td>
					<td><a href="/Softserve_library/reader/delete/${reader.readerId}" class="btn btn-danger btn-xs btn-block"><span
							class="glyphicon glyphicon-minus"></span>Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>