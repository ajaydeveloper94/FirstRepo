package flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PaymentGatewayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PaymentGatewayServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
    
    protected void paymentGateway(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("paymentgateway.jsp");
		String cardnumber = request.getParameter("debitcardnumber");
		String cardexpirtydate = request.getParameter("debitcardexpirydate");
		String cardcvv = request.getParameter("debitcardcvv");
		
		if(cardnumber.equals("000000000000") && cardexpirtydate.equals("0000") && cardcvv.equals("000"))
		{
			out.println("Your payment is success!");
		}
		else
		{
			out.println("Please enter valid card credentials");
		}
	}
}
