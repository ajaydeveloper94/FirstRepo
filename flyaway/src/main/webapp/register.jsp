<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRATION PAGE</title>
</head>
<body>

     
<hr>
<h1>Please fill the following details to Register</h1>
<hr>
<br>
<br>
<form action="register-servlet" method="post">
<table>
  <tr>
    <td><label for="userName">User Name:</label></td>
    <td><input name="userName" type="text" class="form-control" id="userName" placeholder="Enter Name"></td>
  </tr>
  
   <tr><td><br></td></tr>
   
  <tr>
    <td><label for="password">Password:</label></td>
    <td><input name="password" type="password" placeholder="password"></td>
  </tr>
  
   <tr><td><br></td></tr>
   
  <tr>
    <td><label for="email">E-Mail Id:</label></td>
    <td><input name="email" type="email" class="form-control" id="email" placeholder="Enter Email-id"></td>
  </tr>
  
   <tr><td><br></td></tr>
   
  <tr>
    <td><label for="mobile">Mobile Number:</label></td>
    <td><input name="mobile" type="tel" pattern="[0-9]{10}" class="form-control" id="mobile" placeholder="10-digit Mobile Number"></td>
  </tr>
  
   <tr><td><br></td></tr>
  
  <tr>
    <td><label for="address">Address:</label></td>
    <td><textarea name="address" style="height: 100px" class="form-control" id="address" placeholder="Enter Address"></textarea></td>
  </tr>
  
   <tr><td><br></td></tr>
   
  <tr>
    <td><label for="usertype">User Type:</label></td>
    <td><select name="usertype" id="usertype">
          <option value="Normal">Normal</option>
          <option value="Admin">Admin</option>
        </select></td>
  </tr>
  
   <tr><td><br></td></tr>
   
  <tr>
    <td><button type="submit" class="btn btn-outline-success">Register</button></td>
    <td><button type="reset" class="btn btn-outline-danger">Reset</button></td>
    <td><nav><a href="login.jsp">Login Here</a>
 </nav></td>
  </tr>
</table>
</form>
</body>
</html>