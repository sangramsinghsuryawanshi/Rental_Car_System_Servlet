<%@page import="com.RentCar.dao.QueryConnections"%>
<%@page import="com.RentCar.been.VehicalClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rent Vehicles</title>
<link rel="stylesheet" type="text/css" href="css/vehicaluser.css">
</head>
<body>
	 <header>
        <a href="home.jsp">Home</a>
        <a href="vehicaluser.jsp">Vehicles</a>
        <a href="contact.jsp">Contact Us</a>
        <a href="RentCarSystemServletPage">Logout</a>
        <a href="Register.jsp">Register</a>
    </header>
	
	<div class="vehicle-list">
    <% 
        List<VehicalClass> vehicles = QueryConnections.getAllVehicles();
        for (VehicalClass vc : vehicles) 
        { 
    %>
    <div class="vehicle-item">
        <img src="VehicalImages/<%= vc.getImagePath() %>" alt="<%= vc.getMake() %> Image" class="vehicle-image">
        <div class="vehicle-details">
            <h2><%= vc.getMake() %> <%= vc.getModel() %></h2>
            <p><strong>Year:</strong> <%= vc.getYear() %></p>
            <p><strong>Rs.</strong><%= vc.getPrice() %></p>
            <p><strong>Description:</strong> <%= vc.getDescription() %></p>
            <form action="#" method="post">
                <input type="hidden" name="vehicleId" value="<%= vc.getVehicleId() %>">
                <input type="submit" value="Buy Now" class="buy-button">
            </form>
        </div>
    </div>
    <% } %>
</div>
<footer>
        <p>&copy; 2024 Rent Car System. All rights reserved.</p>
        <a href="terms.jsp">Terms of Service</a> | 
        <a href="privacy.jsp">Privacy Policy</a>
    </footer>
</body>
</html>