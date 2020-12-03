<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.entities.BookingTable" %>
<%@ page import="flyaway.dao.BookingDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOKING LIST</title>
</head>
<body>
<%-- Retrieve info from the table --%>
<%BookingDAO bookingdao = new BookingDAO(); 
  List<BookingTable> bookinglist = bookingdao.getBookingDetails();%>


<nav><a href="addairlines.jsp">Add Airline</a>
     <a href="addflight.jsp">Add Flight</a>
     <a href="addsource.jsp">Add Source</a>
     <a href="adddestination.jsp">Add Destination</a>
     <a href="flightlist.jsp ">Flight List</a>
     <a href="bookinglist.jsp ">Booking List</a>
     <a href="createflights.jsp">Create Flights</a>
     <a href="logout-servlet">Logout</a></nav>
<br>
<hr>

<p>TOTAL BOOKING LIST</p>
<form action="" method="post">

     <label for="bookingList">Booking List</label><br>
   <table border="1">
   <tr>
     <td></td>
     <th>Booking ID</th><th>Airline Name </th><th>Flight Name</th><th> User Name</th><th> Date</th><th> No.of Persons</th><th> Source Name</th><th> Destination Name</th><th> Total Price</th>
   </tr>
   <%-- Display info of booking table --%>
     <%for(BookingTable bookingtablelist: bookinglist){ %>
   
        
        <tr><td><input type="text" name="flightName" id="flight" value="bookinglist"> </td>
        <td><%=bookingtablelist.getBTId()+" "+" "%></td>
        <td><%=bookingtablelist.getAName()+" "+" "%></td>
        <td><%=bookingtablelist.getFName()+" "+" "%></td>
        <td><%=bookingtablelist.getUName()+" "+" "%></td>
        <td><%=bookingtablelist.getDate()+" "+" "%></td>
        <td><%=bookingtablelist.getNumberOfPersons()%></td>
        <td><%=bookingtablelist.getSName()+" "+" "%></td>
        <td><%=bookingtablelist.getDName()+" "+" "%></td>
        <td><%=bookingtablelist.getTotalPrice() %></tr>
          <%} %>
   </table>

</form>

</body>
</html>