<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>
<%
   String title = "Welcome Back to my website";
   String userIDKey = new String("userID");
   String userID = new String("ABCD");
   userID = (String) request.getAttribute("username");
   if(userID == null){
	   userID = (String)session.getAttribute(userIDKey);
	   
	   if(userID == null){
		   response.sendRedirect("index.jsp");
	   }
   }else {
	   title = "Welcome to my website";
	   session.setAttribute(userIDKey, userID);
   }
   userID = (String)session.getAttribute(userIDKey);
%>

<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Home</title>
</head>
<body style="background-color:#add8e6">

<jsp:include page="/Navbar.jsp"/>
<h1><% out.print("Welcome on Weather,"+ session.getAttribute(userIDKey)); %> </h1>
<form action="AddLocation" method="post">	
	<h3>Enter a city to add in your account</h3>
		<table style="with: 100%">
		    <tr>
		     <td><input type="text" name="city"/></td>
		    </tr>
		</table>
	<input type="submit" value="Add a City" />
</form>
<br><br>
<form action="RemoveLocation" method="post">	
		<h3>Enter a city to remove it from account</h3>
		<table style="with: 100%">
		    <tr>
		     <td><input type="text" name="city"/></td>
		    </tr>
		</table>
	<input type="submit" value="Remove a City" />
</form>
<h1>Your locations:</h1>
				<br>
<jsp:include page="/OnLoad"/>

<br>
<a href="https://openweathermap.org">Powered by openweathermap</a>
</body>
</html>