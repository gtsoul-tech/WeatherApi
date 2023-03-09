<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
</head>
<body style="background-color:#add8e6">
<jsp:include page="Navbar.jsp"/>
<div class="row">
  <div class="col-sm-6" >
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
</div>
<div class="col-sm-6">
<h1>${weather.city}/${weather.countrycode} </h1>
		<div class="temperature">
			<h3 class="temperature-degree" >Current ${weather.temperature}</h3>
			<h5 class="temperature-humidity" >Temperatures <br>Max ${weather.tempmax}<br>Min ${weather.tempmin}<br>Humidity ${weather.humidity}</h5>
			<div class="icon">
			<img src=icons/${weather.iconsrc}.png alt="">
			</div>
			<div class="temperature-description">
				${weather.description}<br>
			</div>
</div>
</div>
</div>
</body>
</html>