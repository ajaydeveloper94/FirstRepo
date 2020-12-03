<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="flyaway.dao.UserDAO" %>
<%@ page import="flyaway.entities.UserTable" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PERSONAL DETAILS</title>
</head>
<body>
<h1>Personal Details</h1>
<hr>

<%-- Navigation Bar --%>
<nav>
     <a href="logout-servlet">Logout</a></nav>
     
<hr>

<%-- Retrieve Info from Table --%>
<% UserDAO userdao = new UserDAO();
   List<UserTable> userdetails = userdao.getUserByName();
%>


<%-- Create Session --%>
 <%
	HttpSession sessionhttp = request.getSession(false);
	String usernamehttp = (String) sessionhttp.getAttribute("userEmailHttp");
 %>
 
 <%String userEmail=null; 
   String userName = null;%>
   
<%-- Display Personal Details --%>
 <form action="bookingdetails.jsp">
 <table>
<% for(UserTable userdetailsfull:userdetails) { 
  if(userdetailsfull.getUserEmail().equals(usernamehttp))
  {%>
    <%userName = userdetailsfull.getUserName(); %>
    <tr>
	 <td>User ID:</td>
	 <td><%=userdetailsfull.getUserId() %></td>
	 </tr>
	<tr>
	 <td>User Name:</td>
	 <td><%=userdetailsfull.getUserName() %></td>
	 </tr>
	 <tr>
	 <td>User Email:</td>
	 <td><%=userdetailsfull.getUserEmail() %></td>
	 </tr>
	 <tr>
	 <td>User Phone:</td>
	 <td><%=userdetailsfull.getUserPhone() %></td>
	 </tr>
	 <tr>
	 <td>User Address:</td>
	 <td><%=userdetailsfull.getUserAddress() %></td>
	 </tr>
 <% }

  }
  %>
  <tr><td><br></td>
      <td><br></td>
  </tr>
 <tr> 
  <td><input type="button" onclick="window.location.href='register.jsp'" value="Edit Details"/></td>
  <td> <input type="submit" value="I confirm"/></td>
 </tr>
 </table>

 <%
 HttpSession sessionhttpusername = request.getSession();
 sessionhttpusername.setAttribute("userNametobook",userName);

 %>
</form>



</body>
</html>