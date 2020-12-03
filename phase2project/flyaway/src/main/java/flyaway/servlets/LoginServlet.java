package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import flyaway.entities.UserTable;
import flyaway.helperapp.HibernateUtil;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	HibernateUtil hibernateutil = new HibernateUtil();
	Session session = hibernateutil.buildSessionFactory();

    public LoginServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		loginRequest(request, response);
	}
	
protected void loginRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    try
	    {
	       response.setContentType("text/html");
	       PrintWriter out = response.getWriter();
	       
	       request.getRequestDispatcher("login.jsp").include(request, response);
	       String userEmail = request.getParameter("email");
	       String userPassword = request.getParameter("password");
	       
	       List<UserTable> listOfUsers = session.createQuery("from UserTable ").getResultList();
	       
	       for(UserTable theUser: listOfUsers )
	       {
	    	   String usermailtostring = theUser.getUserEmail();
	    	   String userpasswordtostring = theUser.getUserPassword();
	    	   
	    	   if(userEmail.equals(usermailtostring) && userPassword.equals(userpasswordtostring))
	    	   {
	    		   if(theUser.getUserType().equals("Admin"))
	    		   {
	    			   HttpSession sessionhttp = request.getSession();
	    			   sessionhttp.setAttribute("userEmailHttp",userEmail);
	    			   
	    			   response.sendRedirect("addflight.jsp");
	    			   
	    		   }else if(theUser.getUserType().equals("Normal")){
	    			   HttpSession sessionhttp = request.getSession();
	    			   sessionhttp.setAttribute("userEmailHttp", userEmail);
	    			   
	    			   response.sendRedirect("dashboardofuser.jsp");
	    		   }
	    	   }else
	    	   {
	    		   out.print("Please Enter valid Credentials");
	    	   }
	       }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	
	}

}
