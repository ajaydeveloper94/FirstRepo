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

import flyaway.dao.FlightDAO;
import flyaway.entities.FlightTable;

@WebServlet("/add-flight")
public class AddFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddFlightServlet() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addFlightServlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addFlightServlet(request, response);
	}
	
    protected void addFlightServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//Retrieve info from the specific page
		request.getRequestDispatcher("addflight.jsp").include(request, response);
		
		//Store it into a string value
		String flightName = request.getParameter("flightName");
		int count=0;
	   
		//Retrieve info and validate
		try
		{   
			FlightDAO theFlight = new FlightDAO();
			List<FlightTable> flighttablelist = theFlight.getFlightByName();
				for(FlightTable flightlist: flighttablelist)
				{
					if(flightlist.getFName().equals(flightName))
					{
						count++;
					}
				}
				if(count==0)
				{
					
				
			theFlight.addFlight(flightName);
			
           out.println(flightName+" "+"registered successfully!");
				}else
				{
					out.println(flightName+"already exists!");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
