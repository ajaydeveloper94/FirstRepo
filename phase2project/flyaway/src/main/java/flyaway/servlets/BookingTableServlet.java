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

import flyaway.dao.BookingDAO;
import flyaway.entities.BookingTable;
import flyaway.helperapp.HibernateUtil;

@WebServlet("/booking-table")
public class BookingTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HibernateUtil hibernateutil = new HibernateUtil();
	Session session = hibernateutil.buildSessionFactory();
	
    public BookingTableServlet() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookingTableServlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bookingTableServlet(request, response);
	}
    
    protected void bookingTableServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out = response.getWriter();
    	
    	//Retrieve info from a specific page
    	request.getRequestDispatcher("searchresult.jsp");
    	
    	String numberofpersons = request.getParameter("quantity");
    	String bookingdetails = request.getParameter("bookflight");
    	String[] bookingdetailssplit = bookingdetails.split(",");
    	
    	
    	//Store into a string
        String AirlineName = null, FlightName=null, SourceName=null, DestinationName=null, Date=null, Price=null, NumberOfPersons=null;
        for(int i=0; i<bookingdetailssplit.length; i++)
        {
        	AirlineName = bookingdetailssplit[0];
        	FlightName=bookingdetailssplit[1];
        	SourceName=bookingdetailssplit[2];
        	DestinationName=bookingdetailssplit[3];
        	Date=bookingdetailssplit[4];
        	Price=bookingdetailssplit[5];
        
    	}
    	
        //Logic
        NumberOfPersons = numberofpersons;
        Integer totalPrice =Integer.parseInt(NumberOfPersons)*Integer.parseInt(Price);
        System.out.println(totalPrice);
        String TotalPrice = totalPrice.toString();
        
        //Create Sesssion
		HttpSession sessionhttp = request.getSession(false);
	    String UserName= (String) sessionhttp.getAttribute("userEmailHttp");
	    
	    //Create booking
        BookingDAO bookingdao = new BookingDAO();
        bookingdao.createBooking(AirlineName, FlightName, Date, Price, SourceName, DestinationName, UserName, NumberOfPersons, TotalPrice);
    	
        response.sendRedirect("personaldetails.jsp");
	}
}
