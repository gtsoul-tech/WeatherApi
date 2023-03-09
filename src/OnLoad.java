

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Set;
import java.util.Iterator;

import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

import java.util.SortedSet; 
import java.util.TreeSet; 
/**
 * Servlet implementation class OnLoad
 */
@WebServlet("/OnLoad")
public class OnLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BaseDao addLocationDao = new BaseDaoImplement();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	    HttpSession session=request.getSession();  
		String username = (String)session.getAttribute("userID");
		
		User myUser= addLocationDao.getUser(username);
	    // check/
			if(myUser!=null) {
		    	Set<Location> tempLocations = addLocationDao.getLocations(username);
		    	request.setAttribute("set", tempLocations);
		    	Iterator<Location> it1 = tempLocations.iterator();

	    		SortedSet<String> myset = new TreeSet<>();
		    	while(it1.hasNext()){
		    		myset.add(it1.next().getCityname());
		    	}

		    	Iterator<String> it = myset.iterator();
		    	 String key = "ab70a823278ee4d36883c622a43524c9";
		    	 OWM owm = new OWM(key);
			     while(it.hasNext()){
			    	 String city="-";
			    	 String temp="-";
			    	 String description="- -";
			    	 String countrycode="-";
			    	 String iconsrc="icons/unknown.png";
		    		 CurrentWeather cwd;
		    		 Weather myCurrentWeather=new Weather();
		    		 HourlyWeatherForecast myForecast=null;
		    		 String temporary=it.next();
		    		 Day day1=new Day();
		    		 Day day2=new Day();
		    		 Day day3=new Day();
		    		 Day day4=new Day();
		    		 
						try {
							 
					    	 cwd = owm.currentWeatherByCityName(temporary);
							 city=cwd.getCityName();
					         Double temperature = (Double)cwd.getMainData().getTemp();
					         Double tempDouble= Math.floor((temperature-273.15)* 100) / 100;
					         temp = tempDouble.toString()  +" C";
					         
					         
					         countrycode = cwd.getSystemData().getCountryCode();
					         description = (String)cwd.component5().get(0).getDescription();
					         iconsrc = (String)cwd.component5().get(0).getIconCode();
					         String tempmin=((Double)Math.floor(((cwd.getMainData().getTempMin()-273.15)*100)/100)).toString()+" C";
					         String tempmax=((Double)Math.floor(((cwd.getMainData().getTempMax()-273.15)*100)/100)).toString()+" C";
					         String humidity=cwd.getMainData().getHumidity().toString()+ " %";
					         myCurrentWeather = new Weather(city,temp,description,countrycode,iconsrc,tempmin,tempmax,humidity);
						} catch (APIException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							 
					    	 myForecast = owm.hourlyWeatherForecastByCityName(temporary);
					    	 
					    	 int daycounter=0;
					    	 Day currentday=new Day();
					    	 for(int i=0;i<32;i++) {
					    		 String[] splitStr = myForecast.component5().get(i).getDateTimeText().split("\\s+");
					    		 if(!currentday.getDate().equals("") && !currentday.getDate().equals(splitStr[0])) {
					    			 if(daycounter==0) {
						    			 day1= new Day(currentday);
						    			 currentday=new Day();
						    		 }else if(daycounter==1){
						    			 day2= new Day(currentday);
						    			 currentday=new Day();
						    		 }else if(daycounter==2) {
						    			 day3= new Day(currentday);
						    			 currentday=new Day();
						    		 }else if(daycounter==3) {
						    			 day4= new Day(currentday);
						    			 currentday=new Day();
						    		 }
					    			 daycounter++;
					    		 }
					    		 
					    		 if(currentday.getDate().equals("")) {
					    			 currentday.setDate(splitStr[0]);
					    		 }
					    		 
					    		 if(splitStr[1].equals("09:00:00")){
					    			 currentday.setTemp8(((Double)Math.floor(((myForecast.component5().get(i).getMainData().getTemp()-273.15)*100)/100)).toString()+" C");
					    			 currentday.setIconsrc8(myForecast.component5().get(i).getWeatherList().get(0).getIconCode());
					    		 }else if(splitStr[1].equals("15:00:00")) {
					    			 currentday.setTemp14(((Double)Math.floor(((myForecast.component5().get(i).getMainData().getTemp()-273.15)*100)/100)).toString()+" C");
					    			 currentday.setIconsrc14(myForecast.component5().get(i).getWeatherList().get(0).getIconCode());
					    		 }else if(splitStr[1].equals("21:00:00")) {
					    			 currentday.setTemp20(((Double)Math.floor(((myForecast.component5().get(i).getMainData().getTemp()-273.15)*100)/100)).toString()+" C");
					    			 currentday.setIconsrc20(myForecast.component5().get(i).getWeatherList().get(0).getIconCode());
					    		 }
					    	 }
							 
						} catch (APIException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	 request.setAttribute("weather",myCurrentWeather);
			    	 request.setAttribute("day1",day1);
			    	 request.setAttribute("day2",day2);
			    	 request.setAttribute("day3",day3);
			    	 request.setAttribute("day4",day4);
			    	 
			    	 request.getRequestDispatcher("eachlocation.jsp").include(request, response);
			    	 

			     }

					request.setAttribute("set", myset);
			}
			
			
		
	    request.getRequestDispatcher("weather.jsp").include(request, response);
	    
	    
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	    
	}

}
