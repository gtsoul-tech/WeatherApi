<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Loggedin</title>
</head>
<body style="background-color:#add8e6">
	<jsp:include page="Navbar.jsp"/>
	 <div align="center">
  		<h1>Already Logged in<br>Do you want to log out?<a href="logout.jsp" class="btn btn-info" role="button">Logout</a></h1>
</div>

</body>
</html>