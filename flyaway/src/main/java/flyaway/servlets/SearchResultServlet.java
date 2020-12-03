package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search-servlet")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SearchResultServlet() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		searchResult(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		searchResult(request, response);
	}
	
    protected void searchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out= response.getWriter();
    	request.getRequestDispatcher("dashboardofuser.jsp").include(request, response);
    	
    	String sourceName = request.getParameter("sourceName");
    	String destinationName = request.getParameter("destinationName");
    	
    	String date=request.getParameter("date");
    	
    	
    	
	}

}
