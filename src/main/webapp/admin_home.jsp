<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.RentCar.dao.QueryConnections"%>
<%@page import="com.RentCar.been.CustomerClass"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<link rel="stylesheet" type="text/css" href="css/admin_home_page.css">
</head>
<body>
	<%
	String email = request.getParameter("email");
	CustomerClass ob = QueryConnections.access(email);
	PrintWriter in = response.getWriter();
	%>
	<header>
		<a href="admin_home.jsp">Home</a> <a href="admin_vehicle.jsp">Vehicles</a>
		<a href="user_data.jsp">User Data</a> <a
			href="RentCarSystemServletPage">Logout</a>
	</header>

	<div class="admin-content">
		<h1>Welcome, Admin</h1>
		<p>Manage the system and oversee all operations:</p>

		<div class="admin-actions">
			<a href="user_data.jsp" class="admin-btn">Manage Users</a>
			<p>Review,remove user accounts from the system.</p>

			<a href="admin_vehicle.jsp" class="admin-btn">Manage Vehicles</a>
			<p>Add new vehicles,delete existing ones.</p>

			<a href="RentCarSystemServletPage" class="admin-btn">Logout</a>
			<p>End your session and exit the admin dashboard.</p>

		</div>
	</div>


	<footer>
		<p>&copy; 2024 Rent Car System. All rights reserved.</p>
		<a href="terms.jsp">Terms of Service</a> | <a href="privacy.jsp">Privacy
			Policy</a>
	</footer>
</body>
</html>