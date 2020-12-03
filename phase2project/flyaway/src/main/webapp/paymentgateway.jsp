<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PAYMENT GATEWAY PAGE</title>
</head>
<body>
<h1>Payment Method Options</h1>

<form action="paymentgatewayvalidation.jsp" method="post">
  <label for="debitcardnumber">CardNumber: </label>
  <input type="text" id="username" name="debitcardnumber"><br>
  
  <label for="debitcardexpirydate">Card Expiry Date: </label>
  <input type="text" id="username" name="debitcardexpirydate"><br>
  
  <label for="debitcardcvv">Card CVV: </label>
  <input type="text" id="username" name="debitcardcvv"><br>
  
  <input type="submit" value="Submit">
</form>


<p> Default Values: DEBIT CARD NUMBER- 0000 0000 0000 0000 (12 0's) <br>
                   DEBIT EXPIRY DATE- 0000 (4 0's) <br>
                   DEBIT CVV- 000 (3 0's) </p>
</body>
</html>