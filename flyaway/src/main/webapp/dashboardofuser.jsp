<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.entities.DestinationTable" %>
<%@ page import="flyaway.entities.SourceTable" %>
<%@ page import="java.util.List" %>
<%@ page import="flyaway.dao.SourceDAO" %>
<%@ page import="flyaway.dao.DestinationDAO" %>
<%@ page import="flyaway.dao.CreateFlightDAO" %>
<%@ page import="flyaway.entities.CreateFlightTable" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER PAGE</title>
</head>
<body>
<h1>Welcome! User</h1>
<%-- Create Session --%>
 <%
	HttpSession sessionhttp = request.getSession(false);
	String usernamehttp = (String) sessionhttp.getAttribute("userEmailHttp");
 %>
 <%=usernamehttp%>
<br>
<hr>
<%--Navigation Bar --%>
<nav>
     <a href="logout-servlet">Logout</a></nav>
     
<hr>

<%-- Retrieve Info from Tables --%>
<p>Search for Flights</p>

<%SourceDAO sourcedao = new SourceDAO();
  List<SourceTable> sourcelist = sourcedao.getSourceByName();%>
  
<%DestinationDAO destinationdao = new DestinationDAO();
  List<DestinationTable> destinationlist = destinationdao.getDestinationByName();%>
  
<%CreateFlightDAO createflightdao = new CreateFlightDAO(); 
  List<CreateFlightTable> createflightlist = createflightdao.getCreateFlightList();%>


 <%-- Display info from tables --%>
<form action="searchresult.jsp" method="post">
<table>
<tr>
    <td><label for="sourceName">Search by Source and Destination</label></td>
    <td><select name="sourceName" id="source">
    <%for(SourceTable sourcetable: sourcelist){ %>
          <option><%=sourcetable.getSName()%></option>
          <%} %>
        </select></td>

    <td><select name="destinationName" id="destination">
    <%for(DestinationTable destinationtable: destinationlist){ %>
          <option><%=destinationtable.getDName()%></option>
          <%} %>
        </select></td>
 
    <td><button type="submit" class="btn btn-outline-success">Search Flights</button></td>
    <td><button type="reset" class="btn btn-outline-danger">Reset</button></td>
  </tr>
</table> 


</form>



<hr>
<p>MOST TRAVELLED ROUTES</p>
<form action="bookingconfirmation.jsp" method="post">

     <label for="flightName">Flights Available:</label><br>
   <table border="1">
   <tr>
     <td></td>
     <th>Airline Name</th><th>Flight Name </th><th>Source Name</th><th> Destination Name</th><th> Date</th><th> Price</th>
   </tr>
     <%for(CreateFlightTable createflighttable: createflightlist){ %>
   
        
        <tr><td><input type="text" name="flightName" id="flight" value=<%=createflighttable.getACFName() + " "+" "+createflighttable.getFCFName()+" "+" "+createflighttable.getSCFName()+" "+" "+createflighttable.getDCFName()+" "+" "+createflighttable.getDate()+" "+" "+createflighttable.getPrice()%>> </td><td> <%=createflighttable.getACFName()+" " + "----"+" "%></td><td><%=createflighttable.getFCFName()+" "+"----"+" "%></td><td><%=createflighttable.getSCFName()+" "+"----"+" "%></td><td><%=createflighttable.getDCFName()+" "+"----"+" "%></td><td><%=createflighttable.getDate()+" "+"----"+" "%></td><td><%=createflighttable.getPrice()%></td></tr>
          <%} %>
   </table>

</form>
</body>
</html>