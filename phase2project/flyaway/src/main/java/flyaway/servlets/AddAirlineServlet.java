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

import flyaway.dao.AirlineDAO;
import flyaway.entities.AirlineTable;

@WebServlet("/add-airline")
public class AddAirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddAirlineServlet() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addAirlineServlet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addAirlineServlet(request, response);
	}
    
    protected void addAirlineServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out=response.getWriter();
    	
    	//Retrieve values from the specific page
    	request.getRequestDispatcher("addairlines.jsp").include(request, response);
    	
    	//Store it into a string value
    	String airlineName = request.getParameter("airlineName");
    	
    	
    	//Retrieve info and validate
    	try
    	{
    		AirlineDAO theAirline = new AirlineDAO();
    		int count=0;
    		List<AirlineTable> airlinetablelist = theAirline.getAirlineByName();
    		for(AirlineTable airlinelist: airlinetablelist)
    		{
    			if(airlinelist.getAName().equals(airlineName))
    			{
    				count++;
    			}
    		}
    		if(count==0)
    		{
    			
    		theAirline.addAirline(airlineName);
    		
            out.println(airlineName+" "+"registered successfully!");
    		}
    		else
    		{
    			out.println(airlineName+" "+"already exists");
    		}
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
