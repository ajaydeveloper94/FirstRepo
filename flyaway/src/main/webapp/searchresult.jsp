<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.helperapp.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="flyaway.dao.CreateFlightDAO" %>
<%@ page import="flyaway.entities.CreateFlightTable" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav>
     <a href="logout-servlet">Logout</a></nav>
     
<hr>


<%HibernateUtil hibernateutil = new HibernateUtil();
Session sessionofsearchresultjsp = hibernateutil.buildSessionFactory(); %>

<%CreateFlightDAO createflightdao = new CreateFlightDAO();
  List<CreateFlightTable> createflighttable = createflightdao.getCreateFlightList();%>
  
<%

String sourceName = request.getParameter("sourceName");
String destinationName = request.getParameter("destinationName");

String date=request.getParameter("date");%>


<%-- Retrieve information from the flight table based on the source and destination --%>
<form action="booking-table" method="post">

<label for="quantity">No. of persons:</label>
  <input type="number" id="quantity" name="quantity" min="1" max="5">
  
  <label for="flightName">Flights Based on your search:</label><br>
   <table border="1">
		   <tr>
		     <td></td>
		     <th>Airline Name</th><th>Flight Name </th><th>Source Name</th><th> Destination Name</th><th> Date</th><th> Price</th>
		   </tr>
    <%for(CreateFlightTable createflightlist: createflighttable)
	{
	  if(createflightlist.getSCFName().equals(sourceName) && createflightlist.getDCFName().equals(destinationName))
	  {%>
		 
        <tr><td><input type="radio" name="bookflight" id="flight" value="<%=createflightlist.getACFName()+","+createflightlist.getFCFName()+","+createflightlist.getSCFName()+","+createflightlist.getDCFName()+","+createflightlist.getDate()+","+createflightlist.getPrice()%>"> </td><td> <%=createflightlist.getACFName()+" " + "----"+" "%></td><td><%=createflightlist.getFCFName()+" "+"----"+" "%></td><td><%=createflightlist.getSCFName()+" "+"----"+" "%></td><td><%=createflightlist.getDCFName()+" "+"----"+" "%></td><td><%=createflightlist.getDate()+" "+"----"+" "%></td><td><%=createflightlist.getPrice() %></td></tr>
		          <%} %>
		  
	 <% } %>
   <tr> <td></td>
   <td><button type="submit" class="btn btn-outline-success">Select Flights</button></td>
    <td><button type="reset" class="btn btn-outline-danger">Reset</button></td></tr>
 </table>
</form>


</body>
</html>