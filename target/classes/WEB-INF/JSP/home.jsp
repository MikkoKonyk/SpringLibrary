<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/JSP/includes.jsp"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Check page</title>
<link rel ="stylesheet" type = "text/css" href = "/resources/css/homeStyle.css"></link>
<script src="<c:url value="/resources/js/readerDto.js" />"></script>

<style >
.jumbotron{
      height: 220px;
      padding: 40px;
      background: #FFDCA6;
}
body {
font-family: Arial, Helvetica, sans-serif;
 background: #FFDCA6;
}
.btn-default{

  background: #FFDCA6;
}

.btn-default:hover{

  background: #00FF00;
}
.btn-default:outline{
  color: #
}
.btn-xlarge {
    padding: 45px 18px;
    font-size: 32px;
    line-height: normal;
    -webkit-border-radius: 8px;
       -moz-border-radius: 8px;
            border-radius: 8px;
    }

  .btn-large {
     padding: 8px 18px;
    font-size: 22px;
    line-height: normal;
    -webkit-border-radius: 8px;
       -moz-border-radius: 8px;
            border-radius: 8px;
  }

.container {
background-color: #FFDCA6;

}


  #toolbar .wrapper {
    text-align: center;
}
h1 {
			font: bold 2.5em "Times New Roman", Times, serif;
		}

</style>
 <title>LIBRARY</title>
</head>
<body>
    <div class="jumbotron">
      <div class="container">
        <div class="col-md-6 col-md-offset-3 centerfy">
 <h1>Welcome to library</h1>      
             </div>
       </div>
    </div>

<div class="container">
  <div class="container">
    <div id='toolbar'>
      <div class='wrapper text-center'>
        <div class="btn-group btn-group-justified">
          <div class="btn-group ">
            <a href="bookDto" class="btn btn-default btn-xlarge glyphicon glyphicon-book " role="button"><br>Books&Authors</a>
          </div>
          <div class="btn-group">
            <a href="book" class="btn  btn-default btn-xlarge glyphicon glyphicon-book" role="button"><br> Books</a>
          </div>
          <div class="btn-group">
            <a href="autor" class="btn btn-default btn-xlarge glyphicon glyphicon-user" role="button"><br>  Authors</a>
          </div>
          <div class="btn-group">
             <a href="storage" class="btn btn-default btn-xlarge glyphicon glyphicon-list" role="button"><br> Storage</a>
          </div>
          <div class="btn-group">
              <a href="reader" class="btn btn-default btn-xlarge glyphicon glyphicon-user" role="button"><br> Readers</a>  
          </div>
        </div>
       </div>
      </div>
    </div>
    </div>
<h1 class="wrapper text-center">Select section using links above</h1>   
</body>
</html>