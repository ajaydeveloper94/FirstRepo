<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.dao.AirlineDAO" %>
<%@ page import="flyaway.entities.AirlineTable" %>
<%@ page import="java.util.List" %>
<%@ page import="flyaway.dao.FlightDAO" %>
<%@ page import="flyaway.dao.SourceDAO" %>
<%@ page import="flyaway.dao.DestinationDAO" %>
<%@ page import="flyaway.dao.CreateFlightDAO" %>
<%@ page import="flyaway.dao.BookingDAO" %>
<%@ page import="flyaway.entities.BookingTable" %>
<%@ page import="flyaway.entities.CreateFlightTable" %>
<%@ page import="flyaway.entities.DestinationTable" %>
<%@ page import="flyaway.entities.FlightTable" %>
<%@ page import="flyaway.entities.SourceTable" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN PAGE</title>
<%-- <link rel="stylesheet" type="text/css" href="style.css"/> --%>
</head>
<body>
 <h1>Welcome! Admin</h1>
<br>
<hr>
<%-- Retreve info from the tables --%>
<%AirlineDAO airlinedao = new AirlineDAO();
  List<AirlineTable> airlinelist = airlinedao.getAirlineByName();%>
  
<%FlightDAO flightdao = new FlightDAO(); 
  List<FlightTable> flightlist = flightdao.getFlightByName();%>
  
<%SourceDAO sourcedao = new SourceDAO();
  List<SourceTable> sourcelist = sourcedao.getSourceByName();%>
  
<%DestinationDAO destinationdao = new DestinationDAO();
  List<DestinationTable> destinationlist = destinationdao.getDestinationByName();%>
  
<%-- Navigation Bar --%>
<nav><a href="addairlines.jsp">Add Airline</a>
     <a href="addflight.jsp">Add Flight</a>
     <a href="addsource.jsp">Add Source</a>
     <a href="adddestination.jsp">Add Destination</a>
     <a href="flightlist.jsp">Flight List</a>
     <a href="bookinglist.jsp">Booking List</a>
     <a href="createflights.jsp">Create Flights</a>
     <a href="logout-servlet">Logout</a></nav>
     
<hr>
<%-- Display info of tables --%>
<form action="create-flight" method="post">
<table>
  <th>Create Flight</th>
  <tr>
    <td><label for="airlineName">Airline Name:</label></td>
    <td><select name="airlineName" id="airline">
    <%for(AirlineTable airlinetable: airlinelist){ %>
          <option><%=airlinetable.getAName()%></option>
          <%} %>
        </select></td>
  </tr>
  <tr>
    <td><label for="flightName">Flight Name:</label></td>
    <td><select name="flightName" id="flight">
    <%for(FlightTable flighttable: flightlist){ %>
          <option><%=flighttable.getFName()%></option>
          <%} %>
        </select></td>
  </tr>
  <tr>
    <td><label for="sourceName">Source Name:</label></td>
    <td><select name="sourceName" id="source">
    <%for(SourceTable sourcetable: sourcelist){ %>
          <option><%=sourcetable.getSName()%></option>
          <%} %>
        </select></td>
  </tr>
  <tr>
    <td><label for="destinationName">Destination Name:</label></td>
    <td><select name="destinationName" id="destination">
    <%for(DestinationTable destinationtable: destinationlist){ %>
          <option><%=destinationtable.getDName()%></option>
          <%} %>
        </select></td>
  </tr>
  <tr>
    <td><label for="date">Date</label></td>
    <td><input type="date" name="date" placeholder="select the date"></td>
  </tr>
  <tr>
    <td><label for="price">Price</label></td>
    <td><input type="text" name="price" placeholder="Enter Price"></td>
  </tr>
  <tr>
    <td><button type="submit" class="btn btn-outline-success">Create Flight</button></td>
    <td><button type="reset" class="btn btn-outline-danger">Reset</button></td>
  </tr>
</table> 
</form>
</body>
</html>