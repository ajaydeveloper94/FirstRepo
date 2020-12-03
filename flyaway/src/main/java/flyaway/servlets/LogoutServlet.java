package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout-servlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logOut(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logOut(request, response);
	}
	
    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	 response.setContentType("text/html");
         try (PrintWriter out = response.getWriter()) 
         {
             HttpSession session = request.getSession();

             session.removeAttribute("userEmailHttp");

             response.sendRedirect("login.jsp");
         }
	}

}
