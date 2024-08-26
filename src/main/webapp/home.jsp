<%@page import="com.RentCar.dao.QueryConnections"%>
<%@page import="com.RentCar.been.CustomerClass"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Rent Car System - Home</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<% String email=request.getParameter("email");
CustomerClass ob=QueryConnections.access(email);
PrintWriter in=response.getWriter();
%>
<body>

    <header>
        <a href="home.jsp">Home</a>
        <a href="vehicaluser.jsp">Vehicles</a>
        <a href="contact.jsp">Contact Us</a>
          <a href="userprofile.jsp">User Profile</a>
        <a href="RentCarSystemServletPage">Logout</a>
        <a href="Register.jsp">Register</a>
    </header>
    
    <div class="main-content">
        <h1>Welcome to Rent Car System</h1>
        <p>Your one-stop solution for renting cars at affordable prices.</p>
        
        <h2>Why Choose Us?</h2>
        <div class="info-section">
            <div class="info-item">
                <h3>Affordable Prices</h3>
                <p>We provide competitive rates without compromising on quality. Find the best deals for your rental needs.</p>
            </div>
            <div class="info-item">
                <h3>Wide Selection</h3>
                <p>From luxury sedans to rugged SUVs, we have a diverse fleet of vehicles to choose from. Browse our options and pick the perfect car for you.</p>
            </div>
            <div class="info-item">
                <h3>Excellent Customer Service</h3>
                <p>Our dedicated support team is available 24/7 to assist you with any queries or issues. Your satisfaction is our priority.</p>
            </div>
        </div>
        
    </div>
    <footer>
        <p>&copy; 2024 Rent Car System. All rights reserved.</p>
        <a href="terms.jsp">Terms of Service</a> | 
        <a href="privacy.jsp">Privacy Policy</a>
    </footer>
    
</body>
</html>
