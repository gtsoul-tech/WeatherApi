import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterDao extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDao() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("register.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg="Unsuccessfull register";
  String page = "register.jsp";
  response.setContentType("text/html;charset=UTF-8");
  PrintWriter out = response.getWriter();
  User user = new User();
  user.setUsername(request.getParameter("username"));
  user.setPassword(request.getParameter("password"));
  if(user.getUsername() =="" || user.getPassword()=="") {

	  out.println("Please enter username and password");
	  request.getRequestDispatcher("register.jsp").include(request, response);
  }
  else {
	  BaseDao baseDao = new BaseDaoImplement();
	  boolean check = baseDao.exists(user);
	  if(check == false) {
		  msg= baseDao.register(user);
		  page = "index.jsp";
		  request.setAttribute("msg2", msg);
		  out.println("User successfully registered");
		  request.getRequestDispatcher(page).include(request, response);
	  }else {
		  out.println("User probably exists");
		  request.getRequestDispatcher("register.jsp").include(request, response);
	  }
  }
 }

}