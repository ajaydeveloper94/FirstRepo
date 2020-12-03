<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.dao.BookingDAO" %>
<%@ page import="flyaway.entities.BookingTable" %>
<%@ page import="java.util.List" %>
<%@ page import="flyaway.helperapp.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="flyaway.dao.UserDAO" %>
<%@ page import="flyaway.entities.UserTable" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- Navigation Bar --%>
<nav>
     <a href="logout-servlet">Logout</a></nav>
     
<hr>

<%-- Create Session and Retrieve Info from the Tables --%>
<%HibernateUtil hibernateutil = new HibernateUtil();
Session booksession = hibernateutil.buildSessionFactory(); %>

 
  <%
	HttpSession sessionhttpusername = request.getSession(false);
	String usernamehttptobook = (String) sessionhttpusername.getAttribute("userNametobook");
 %>


<%BookingDAO bookingdao = new BookingDAO();
  List<BookingTable> bookingdetailstable = bookingdao.getBookingId(); %>

<h1> Your Booking Details</h1>
<hr>
<form action="paymentgateway.jsp" method="post"> 

<%-- Display Info of table --%>
<table border="1">
 <% for(BookingTable bookingdetails: bookingdetailstable) { %>

  
	   <tr>
	 <td>Booking ID:</td>
	 <td><%=bookingdetails.getBTId()%></td>
	 </tr>
	 <tr>
	 <td>User Name:</td>
	 <td><%=usernamehttptobook %></td>
	 </tr>
	<tr>
	 <td>User Email:</td>
	 <td><%=bookingdetails.getUName() %></td>
	 </tr>
	 <tr>
	 <td>Airline Name:</td>
	 <td><%=bookingdetails.getAName() %></td>
	 </tr>
	 <tr>
	 <td>Flight Number</td>
	 <td><%=bookingdetails.getFName()%></td>
	 </tr>
	 <tr>
	 <td>Travel Date:</td>
	 <td><%=bookingdetails.getDate()%></td>
	 </tr>
	 <tr>
	 <td>Source:</td>
	 <td><%=bookingdetails.getSName()%></td>
	 </tr>
	 <tr>
	 <td>Destination:</td>
	 <td><%=bookingdetails.getDName()%></td>
	 </tr>
	 <tr>
	 <td>Number of Persons:</td>
	 <td><%=bookingdetails.getNumberOfPersons()%></td>
	 </tr>
	  <tr>
	 <td>Total Price:</td>
	 <td><%=bookingdetails.getTotalPrice()%></td>
	 </tr>
 <% 
  }%>
  
  <tr><td><br></td>
      <td><br></td>
  </tr>
 <tr> 
  <td></td>
  <td> <input type="submit" value="I confirm and pay"/></td>
 </tr>
</table>
</form>
</body>
</html>