<%@ page import="com.RentCar.been.VehicalClass" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Update Vehicle</title>
    <link rel="stylesheet" type="text/css" href="css/admin_vehicles.css">
</head>
<body>
    <div class="form-container">
        <h1>Update Vehicle</h1>
        <%
            VehicalClass vehicle = (VehicalClass) request.getAttribute("vehicle");
            if (vehicle != null) 
            {
        %>
        <form action="RentCarSystemServletPage" method="post" enctype="multipart/form-data">
            <input type="hidden" name="operation" value="saveUpdatedVehicle">
            <input type="hidden" name="vehicleId" value="<%= vehicle.getVehicleId() %>">
            
            <label for="make">Make</label>
            <input type="text" id="make" name="make" value="<%= vehicle.getMake() %>" required>
            
            <label for="model">Model</label>
            <input type="text" id="model" name="model" value="<%= vehicle.getModel() %>" required>
            
            <label for="year">Year</label>
            <input type="number" id="year" name="year" value="<%= vehicle.getYear() %>" required>
            
            <label for="price">Price</label>
            <input type="number" id="price" name="price" value="<%= vehicle.getPrice() %>" step="0.01" required>
            
            <label for="description">Description</label>
            <textarea id="description" name="description" rows="4" required><%= vehicle.getDescription() %></textarea>
            
            <label for="image">Image</label>
            <input type="file" id="image" name="imagePath" accept="image/*">
            
            <input type="submit" value="Update Vehicle">
        </form>
        <% } 
            else 
            { %>
        <p>Vehicle details not available.</p>
        <% } %>
    </div>
</body>
</html>
