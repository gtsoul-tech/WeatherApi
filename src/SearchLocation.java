

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;  
import javax.servlet.http.*;  


import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
/**
 * Servlet implementation class SearchLocation
 */
@WebServlet("/SearchLocation")
public class SearchLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String city = request.getParameter("city");
		int flag=0;
    	String key = "keyasd";
    	OWM owm = new OWM(key);
    	CurrentWeather cwd;
    	Weather myWeather=new Weather();
    	try {
    		 cwd = owm.currentWeatherByCityName(city);
    		 city=cwd.getCityName();
	         Double temperature = (Double)cwd.getMainData().getTemp();
	         Double tempDouble= Math.floor((temperature-273.15)* 100) / 100;
	         String temp = tempDouble.toString()  +" C";
	         
	         
	         String  countrycode = cwd.getSystemData().getCountryCode();
	         String description = (String)cwd.component5().get(0).getDescription();
	         String iconsrc = (String)cwd.component5().get(0).getIconCode();
	         String tempmin=((Double)Math.floor(((cwd.getMainData().getTempMin()-273.15)*100)/100)).toString()+" C";
	         String tempmax=((Double)Math.floor(((cwd.getMainData().getTempMax()-273.15)*100)/100)).toString()+" C";
	         String humidity=cwd.getMainData().getHumidity().toString()+ " %";
	         myWeather = new Weather(city,temp,description,countrycode,iconsrc,tempmin,tempmax,humidity);
		} catch (APIException e) {
			System.out.println("Wrong city name search");
			out.println("Wrong city name");
			request.getRequestDispatcher("searchform.jsp").include(request, response);
			flag=1;
		}
    	if(flag==0) {
    		request.setAttribute("weather", myWeather);
    		request.setAttribute("searched", "searched");
	    	request.getRequestDispatcher("search.jsp").include(request, response);
    	}
	}
}
