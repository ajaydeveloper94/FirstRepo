<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav><a href="logout-servlet">Logout</a></nav>
<hr>
<%
request.getRequestDispatcher("paymentgateway.jsp");
String cardnumber = request.getParameter("debitcardnumber");
String cardexpirtydate = request.getParameter("debitcardexpirydate");
String cardcvv = request.getParameter("debitcardcvv");

if(cardnumber.equals("000000000000") && cardexpirtydate.equals("0000") && cardcvv.equals("000"))
{
	out.println("Your payment is success!");
}
else
{
	out.println("Please enter valid card credentials");
} %>
</body>
</html>