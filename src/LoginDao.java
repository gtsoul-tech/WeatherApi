
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginController
 */
public class LoginDao extends HttpServlet {
 private static final long serialVersionUID = 1L;


 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.sendRedirect("index.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  
  String page = "index.jsp";
  if(username =="" || password=="") {
	  out.println("Please enter username and password");
	  request.getRequestDispatcher(page).include(request, response);
  }
  else {
	  if(username.trim().length() >= 0 && username != null &&
	    password.trim().length() >= 0 && password != null) {
	   LoginService loginService = new LoginServiceImplement();
	   boolean flag = loginService.login(username, password);
	   if(flag) {
	    System.out.println("Login success");
	    request.setAttribute("username", username);
	    request.setAttribute("msg", "Login Success.....");
	    page = "LoggedIn";
	   } else {
		   out.println("Username or Password incorrect");
	   }
	  } else {
	    request.setAttribute("msg", "Enter username and password");
	  }
	  request.getRequestDispatcher(page).include(request, response);
	 }
 }
}