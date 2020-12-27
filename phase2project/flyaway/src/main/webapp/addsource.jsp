<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD SOURCE PAGE</title>
</head>
<body>


<h1>Welcome! Admin</h1>
<hr>
<br>
<%-- Navigation Bar --%>
<nav><a href="addairlines.jsp">Add Airline</a>
     <a href="addflight.jsp">Add Flight</a>
     <a href="addsource.jsp">Add Source</a>
     <a href="adddestination.jsp">Add Destination</a>
     <a href="flightlist.jsp">Flight List</a>
     <a href="bookinglist.jsp">Booking List</a>
     <a href="createflights.jsp">Create Flights</a>
     <a href="logout-servlet">Logout</a></nav>
<br>
<hr>
<%-- Add Source --%>
<form action="add-source" method="post">
<table>
<tr>
<td>Add Source</td>
<td><input name="sourceName" type="text" placeholder="Enter Source Name"></td>
</tr>
<tr>
    <td><button type="submit" class="btn btn-outline-success">Add Source</button></td>
    <td><button type="reset" class="btn btn-outline-danger">Reset</button></td>
  </tr>
</table>
</form>

</body>
</html>