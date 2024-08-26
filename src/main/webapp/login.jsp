<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="form-container">
       <h1>Login Form</h1>
        <form action="RentCarSystemServletPage" method="post">
        	<input type="hidden" name="operation" value="login">
			<label for="name">Email:</label>
            <input type="text" name="email" placeholder="Enter your email" required>
            <label for="pass">Pass:</label>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
            <a class="register-link" href="Register.jsp">Register</a>
        </form>
    </div>
</body>
</html>