

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
 * Servlet implementation class AddLocation
 */
@WebServlet("/AddLocation")
public class AddLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLocation() {
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
		BaseDao addLocationDao = new BaseDaoImplement();
		String city = request.getParameter("city");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	    HttpSession session=request.getSession();  
		String username = (String)session.getAttribute("userID");
		
		
		if(city =="") {
			  out.println("Please enter a valid city");
			  //request.getRequestDispatcher("/OnLoad").include(request, response);
			  request.getRequestDispatcher("/WEB-INF/home.jsp").include(request, response);
	    }
	    else {
	    	int flag=0;
	    	String key = "ab70a823278ee4d36883c622a43524c9";
	    	OWM owm = new OWM(key);
	    	CurrentWeather cwd;
	    	try {
	    		 cwd = owm.currentWeatherByCityName(city);
	    		 city=cwd.getCityName();
			} catch (APIException e) {
				System.out.println("Wrong city name");
				out.println("Wrong Cityname to add");
				request.getRequestDispatcher("/WEB-INF/home.jsp").include(request, response);
				flag=1;
			}
	    	
	    	if(flag==0) {
		    	User myUser= addLocationDao.getUser(username);
		    	Location myLocation = new Location();
		    	myLocation.setCityname(city);
		    	myLocation.addUser(myUser);
		    	addLocationDao.registerLocation(myLocation);
		    	/*
		    	Set<Location> tempLocations = addLocationDao.getLocations(username);
		    	out.print(tempLocations);*/
		    	//request.getRequestDispatcher("/OnLoad").include(request, response);
		    	request.getRequestDispatcher("/WEB-INF/home.jsp").include(request, response);
	    	}
	    }
		
		//doGet(request, response);
	}

}
