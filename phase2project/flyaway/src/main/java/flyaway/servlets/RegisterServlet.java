package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import flyaway.dao.UserDAO;
import flyaway.entities.UserTable;
import flyaway.helperapp.HibernateUtil;


@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    
    public RegisterServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userRegistration(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userRegistration(request, response);
	}
    
    protected void userRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			PrintWriter out=response.getWriter();
			
			request.getRequestDispatcher("register.jsp").include(request, response);
			
			String userName= request.getParameter("userName");
			String userEmail= request.getParameter("email");
			String userPassword= request.getParameter("password");
			String userPhone= request.getParameter("mobile");
			String userAddress= request.getParameter("address");
			String userType= request.getParameter("usertype");
			
			HttpSession httpsession=request.getSession();
			
			try {
			    UserDAO theUser = new UserDAO();
			
			    theUser.addUser(userName, userEmail, userPassword, userPhone, userAddress, userType);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
	        httpsession.setAttribute("message", "Registration Successful!"+" "+userName);
	        
	        String registeruser = (String)httpsession.getAttribute("message");
			out.println("Message" + registeruser);
	       
			
			
		}catch(Exception e) {
			
		}
	}
}
