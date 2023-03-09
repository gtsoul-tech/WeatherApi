<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Search</title>
</head>
<body style="background-color:#add8e6">
	<jsp:include page="Navbar.jsp"/>
	 <form action="SearchLocation" method="post">	
		<h3>Search current weather</h3>
			<table style="with: 100%">
			    <tr>
			     <td><input type="text" name="city"/></td>
			    </tr>
			</table>
		<input type="submit" value="Search cityname" />
	</form>
   <a href="https://openweathermap.org">Powered by OpenWeatherMap</a>
</body>
</html>