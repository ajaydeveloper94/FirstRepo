<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<nav><a href="index.jsp">Home</a></nav>
<br>
<hr>
<h1>Please Enter Details To Login</h1>
<hr>
   <table>
	<div class="card-body">
		<form action="login-servlet" method="post">
			<div class="form-group">
			   <tr>
			         <td>	<label for="email">Email address</label> </td>
			         <td>	<input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"> </td>
			  </tr>
			  
			  <tr><td><small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small></td></tr>
			</div>
			
			
			<div class="form-group">
			   <tr>
				  <td><label for="password">Password</label> </td>
				  <td><input name="password" type="password" class="form-control" id="password" placeholder="Password"></td>
			   </tr>
			</div>
			
              <tr><td><br></td></tr>
		      <tr>
		        <td><a href="register.jsp" class="text-center d-block mb-3">If not
				registered click here.</a></td>
			  </tr>
				
			<br>
			<br>	
			<tr><td><br></td></tr>
			<div class="container text-center">
			  <tr>
				  <td><button type="submit" class="btn btn-outline-success">Login</button></td>
			      <td><button type="reset" class="btn btn-outline-danger">Reset</button></td>
			 </tr>
			</div>
		</form>
    </div>
   </table>
</body>
</html>