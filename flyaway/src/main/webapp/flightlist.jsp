<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.entities.CreateFlightTable" %>
<%@ page import="flyaway.dao.CreateFlightDAO" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLIGHT LIST</title>
</head>
<body>
<%-- Retrieve info from flight table --%>
<%CreateFlightDAO createflightdao = new CreateFlightDAO(); 
  List<CreateFlightTable> createflightlist = createflightdao.getCreateFlightList();%>


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

<%-- Display info from Table --%>
<h1>TOTAL FLIGHTS RUNNING</h1>
<form action="" method="post">

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