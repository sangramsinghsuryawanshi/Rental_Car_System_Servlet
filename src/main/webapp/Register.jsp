<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration From</title>
<link rel="stylesheet" type="text/css" href="css/register_page.css">
</head>
<body>
	<div class="Register">
	<h1>Registration Form</h1>
	<form action="RentCarSystemServletPage" method="post">
		<input type="hidden" name="operation" value="register">
		<label>Name: </label>
		<input type="text" name="name" placeholder="Enter your name" required>
		<label>Email: </label>
		<input type="email" name="email" placeholder="Enter your email" required>
		<label>Phone: </label>
		<input type="number" name="phone" placeholder="Enter your phone number" required>
		<label>Password: </label>
		<input type="password" name="password" placeholder="Enter your password" required>
		<label>User_Type: </label>
		<input type="text" name="user_type" placeholder="Enter user_type admin/user" required>
		<input type="submit" value="Register">
	</form>
	</div>
</body>
</html>