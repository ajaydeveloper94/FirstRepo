package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flyaway.dao.DestinationDAO;
import flyaway.entities.DestinationTable;

@WebServlet("/add-destination")
public class AddDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddDestinationServlet() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addDestinationServlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		addDestinationServlet(request, response);
	}

	protected void addDestinationServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   PrintWriter out = response.getWriter();
	   
	   //retrieve the values from the specific page
	   request.getRequestDispatcher("adddestination.jsp").include(request, response);
	   
	   //Store it into a string value
	   String destinationName = request.getParameter("destinationName");
	   
	   int count=0;
	   
	   //Retrieve info and validate
	   try
	   {
		   DestinationDAO theDestination = new DestinationDAO();
		   List<DestinationTable> destinationtablelist = theDestination.getDestinationByName();
		   for(DestinationTable destinationlist: destinationtablelist)
		   {
			   if(destinationlist.getDName().equals(destinationName))
			   {
				   count++;
			   }
		   }
		   if(count==0)
		   {
			   theDestination.addDestination(destinationName);
			   out.println(destinationName+" "+"successfully registered!");
		   }
		   else
		   {
			   out.println(destinationName+" "+"is already registered");
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	       
	}

}
