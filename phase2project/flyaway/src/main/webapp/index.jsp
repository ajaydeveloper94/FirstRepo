<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.entities.CreateFlightTable" %>
<%@ page import="flyaway.dao.CreateFlightDAO" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MAIN PAGE OF WEBSITE</title>
</head>
<body>
<h1>FLYAWAY</h1>

<%-- Navigation bar --%>
<nav><a href="login.jsp">Login</a>
     <a href="register.jsp">Register</a>
</nav>
<br>
<br>     
<hr>

<%--Retrieve Info from table --%>
<%CreateFlightDAO createflightdao = new CreateFlightDAO(); 
  List<CreateFlightTable> createflightlist = createflightdao.getCreateFlightList();%>

<%-- Display info from table --%>
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