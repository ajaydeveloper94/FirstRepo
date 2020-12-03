<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD AIRLINES PAGE</title>
</head>
<body>


<h1>Welcome! Admin</h1>
<hr>
<br>

<%--Navigation Bar --%>

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
<%--Add Airline By Admin --%>
<form action="add-airline" method="post">
<table>
<tr>
<td>Add Airlines</td>
<td><input name="airlineName" type="text" placeholder="Enter AirLine Name"></td>
</tr>
<tr>
    <td><button type="submit" class="btn btn-outline-success">Add Flight</button></td>
    <td><button type="reset" class="btn btn-outline-danger">Reset</button></td>
  </tr>
</table>
</form>
</body>
</html>