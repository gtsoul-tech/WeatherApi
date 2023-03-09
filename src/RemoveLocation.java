

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

import javax.servlet.*;  
import javax.servlet.http.*;  

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Servlet implementation class RemoveLocation
 */
@WebServlet("/RemoveLocation")
public class RemoveLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLocation() {
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
		//doGet(request, response);
		BaseDao removeLocationDao = new BaseDaoImplement();
		String city = request.getParameter("city");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	    HttpSession session=request.getSession();  
		String username = (String)session.getAttribute("userID");
		int flag=0;
    	String key = "keyasd";
    	OWM owm = new OWM(key);
    	CurrentWeather cwd;
    	try {
    		 cwd = owm.currentWeatherByCityName(city);
		} catch (APIException e) {
			System.out.println("Wrong city name");
			out.println("Wrong Cityname to remove");
			request.getRequestDispatcher("/WEB-INF/home.jsp").include(request, response);
			flag=1;
		}
    	
    	if(flag==0) {
			if(city =="") {
				  out.println("Please enter a valid city");
				  //request.getRequestDispatcher("/OnLoad").include(request, response);
				  request.getRequestDispatcher("/WEB-INF/home.jsp").include(request, response);
		    }
		    else {
		    	User myUser= removeLocationDao.getUser(username);
		    	Set<Location> temp=myUser.getLocation();
		    		Location myLocation = new Location();
			    	myLocation.setCityname(city);
			    	myLocation.addUser(myUser);
			    	String msg=removeLocationDao.removeLocation(myLocation,myUser);
			   if(msg!=null) {
			    	out.println(msg);
			    }
		    	request.getRequestDispatcher("/WEB-INF/home.jsp").include(request, response);
		    	
		    	
		    }
    	}
	}

}
