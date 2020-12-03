package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flyaway.dao.CreateFlightDAO;
import flyaway.entities.CreateFlightTable;

@WebServlet("/create-flight")
public class CreateFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 266347201953265179L;

public CreateFlightsServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createFlights(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		createFlights(request, response);
	}

    protected void createFlights(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out= response.getWriter();
		request.getRequestDispatcher("createflights.jsp").include(request, response);
		
		String airlineName = request.getParameter("airlineName");
		String flightName = request.getParameter("flightName");
		String sourceName = request.getParameter("sourceName");
		String destinationName = request.getParameter("destinationName");
		String Date = request.getParameter("date");
		String price = request.getParameter("price");
		
		
		
		int count=0;
		
		try
		{
			CreateFlightDAO theCreateFlight = new CreateFlightDAO();
			List<CreateFlightTable> createflighttablelist = theCreateFlight.getCreateFlightList();
			for(CreateFlightTable createflightlist: createflighttablelist )
			{
				if(createflightlist.getFCFName().equals(flightName) && createflightlist.getSCFName().equals(sourceName) && createflightlist.getDCFName().equals(destinationName))
				{
					count++;
				}
			}
			if(count==0)
			{
				theCreateFlight.createFlight(airlineName, flightName, Date, sourceName, destinationName, price);
				out.println("Flight has been created");
			}
			else
			{
				out.println("Your flight has already on its way to destination, please choose another flight");
			}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
    }
}
