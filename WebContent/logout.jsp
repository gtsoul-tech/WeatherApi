<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    if(session!=null)
         {
          session.invalidate();
         }
    %>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>LoggedOut</title>
</head>
<body style="background-color:#add8e6">
	<jsp:include page="Navbar.jsp"/>
	<div align="center">
  		<h1>Logged Out</h1>
  		<div align="center">
		  <h1>Login</h1>
		  <form action="login" method="post">
		   <table style="with: 100%">
		    <tr>
		     <td>UserName</td>
		     <td><input type="text" name="username" /></td>
		    </tr>
		    <tr>
		     <td>Password</td>
		     <td><input type="password" name="password" /></td>
		    </tr>
			
		   </table>
		   <input type="submit" value="Submit" />
		  </form>
		  <h2>You should register and login to get access to the features(Weather)</h2>
	 </div>
 	</div>
</body>
</html>