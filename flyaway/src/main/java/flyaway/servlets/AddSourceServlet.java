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

import flyaway.dao.SourceDAO;
import flyaway.entities.SourceTable;

@WebServlet("/add-source")
public class AddSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddSourceServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addSourceServlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addSourceServlet(request, response);
	}
    
    protected void addSourceServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
    	PrintWriter out = response.getWriter();
    	
    	//Retrieve info from a specific page
    	request.getRequestDispatcher("addsource.jsp").include(request, response);
    	
    	//Store it into a string value
    	String sourceName = request.getParameter("sourceName");
    	
    	//Create a session
    	HttpSession httpsession=request.getSession();
    	
    	//Retrieve info and validate
    	try
    	{
    	
    		SourceDAO theSource = new SourceDAO();
    		int count=0;
    		List<SourceTable> sourcetablelist = theSource.getSourceByName();
    		for(SourceTable sourcelist: sourcetablelist)
    		{
    			
    		if(sourcelist.getSName().equals(sourceName))
    		{
    			count++;
    		}
    		}
    		if(count==0)
    		{
    			
    		theSource.addSource(sourceName);
    		
            out.println(sourceName+" "+"registered successfully!");
    		}
    		else
    		{
    			out.println(sourceName+" "+"already exists");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
}
