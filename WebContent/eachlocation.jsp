<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<meta charset="ISO-8859-1">
<title>${city}</title>
</head>
<body style="background-color:#add8e6">
<div class="row">
  <div class="col-sm-3" style="background-color=#707070">
  		<br>
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
  <div class="col-sm-2 " style="background-color=#707070">
  <br><h1>${day1.date}</h1><br>
  <h3>9:00</h3><br>
  <div class="icon">
  <img src=icons/${day1.iconsrc8}.png  width="80" height="40" alt="">
  </div>
  <h6>${day1.temp8}</h6><br>
  <h3>15:00</h3><br>
  <div class="icon">
  <img src=icons/${day1.iconsrc14}.png width="80" height="40" alt="">
  </div>
  <h6>${day1.temp14}</h6><br>
  <h3>21:00</h3><br>
  <div class="icon">
  <img src=icons/${day1.iconsrc20}.png  width="80" height="40" alt="">
  </div>
  <h6>${day1.temp20}</h6><br>
  
  
  </div>
  
  <div class="col-sm-2">
  <br><h1>${day2.date}</h1><br>
  <h3>9:00</h3><br>
  <div class="icon">
  <img src=icons/${day2.iconsrc8}.png  width="80" height="40" alt="">
  </div>
  <h6>${day2.temp8}</h6><br>
  <h3>15:00</h3><br>
  <div class="icon">
  <img src=icons/${day2.iconsrc14}.png width="80" height="40" alt="">
  </div>
  <h6>${day2.temp14}</h6><br>
  <h3>21:00</h3><br>
  <div class="icon">
  <img src=icons/${day2.iconsrc20}.png  width="80" height="40" alt="">
  </div>
  <h6>${day2.temp20}</h6><br>
  </div>
  
  <div class="col-sm-2" style="background-color=#707070">
  <br><h1>${day3.date}</h1><br>
  <h3>9:00</h3><br>
  <div class="icon">
  <img src=icons/${day3.iconsrc8}.png  width="80" height="40" alt="">
  </div>
  <h6>${day3.temp8}</h6><br>
  <h3>15:00</h3><br>
  <div class="icon">
  <img src=icons/${day3.iconsrc14}.png width="80" height="40" alt="">
  </div>
  <h6>${day3.temp14}</h6><br>
  <h3>21:00</h3><br>
  <div class="icon">
  <img src=icons/${day3.iconsrc20}.png  width="80" height="40" alt="">
  </div>
  <h6>${day3.temp20}</h6><br>
  </div>
  
  <div class="col-sm-2">
  <br><h1>${day4.date}</h1><br>
  <h3>9:00</h3><br>
  <div class="icon">
  <img src=icons/${day4.iconsrc8}.png  width="80" height="40" alt="">
  </div>
  <h6>${day4.temp8}</h6><br>
  <h3>15:00</h3><br>
  <div class="icon">
  <img src=icons/${day4.iconsrc14}.png width="80" height="40" alt="">
  </div>
  <h6>${day4.temp14}</h6><br>
  <h3>21:00</h3><br>
  <div class="icon">
  <img src=icons/${day4.iconsrc20}.png  width="80" height="40" alt="">
  </div>
  <h6>${day4.temp20}</h6><br>
  </div>
</div>
</body>
</html>