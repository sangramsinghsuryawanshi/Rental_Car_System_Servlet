<%@page import="com.RentCar.dao.QueryConnections"%>
<%@page import="com.RentCar.been.VehicalClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Add Vehicle</title>
    <link rel="stylesheet" type="text/css" href="css/admin_vehicles.css">
</head>
<body>
    <header>
        <a href="admin_home.jsp">Home</a>
        <a href="admin_vehicle.jsp">Vehicles</a>
        <a href="user_data.jsp">User Data</a>
        <a href="RentCarSystemServletPage">Logout</a>
    </header>

    <div class="form-container">
        <h1>Add New Vehicle</h1>
          <% 
            String message = (String) request.getAttribute("message");
            if (message != null) 
            {
       	 %>
        	<div class="message"><%= message %></div>
        	<% } %>
        
        <form action="RentCarSystemServletPage" method="post" enctype="multipart/form-data">
            <input type="hidden" name="operation" value="addVehicle">
            
            <label for="make">Makers</label>
            <input type="text" id="make" name="make" placeholder="Enter vehicle make" required>
            
            <label for="model">Model</label>
            <input type="text" id="model" name="model" placeholder="Enter vehicle model" required>
            
            <label for="year">Year</label>
            <input type="number" id="year" name="year" placeholder="Enter vehicle year" required>
            
            <label for="price">Price</label>
            <input type="number" id="price" name="price" placeholder="Enter vehicle price" step="0.01" required>
            
            <label for="description">Description</label>
            <textarea id="description" name="description" placeholder="Enter vehicle description" rows="4" required></textarea>
            
            <label for="image">Image</label>
            <input type="file" id="image" name="imagePath" accept="image/*" required>
            
            <input type="submit" value="Add Vehicle">
        </form>
    </div>
	<div class="table-container">
        <h1>Vehicle List</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Image</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<VehicalClass> vehicles = QueryConnections.getAllVehicles();
                    for (VehicalClass vc : vehicles) { 
                %>
                <tr>
                    <td><%= vc.getVehicleId() %></td>
                    <td><%= vc.getMake() %></td>
                    <td><%= vc.getModel() %></td>
                    <td><%= vc.getYear() %></td>
                    <td>Rs <%= String.format("%.2f", vc.getPrice()) %></td>
                    <td><%= vc.getDescription() %></td>
                    <td><img src="VehicalImages/<%= vc.getImagePath() %>" alt="<%= vc.getMake() %> Image" width="100" height="75"></td>
                    <td>
                        <form action="RentCarSystemServletPage" method="post">
                        	<input type="hidden" name="operation" value="vehicaldelete">
                            <input type="hidden" name="vehicleId" value="<%= vc.getVehicleId() %>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    <td>
                        <form action="RentCarSystemServletPage" method="post">
                        	<input type="hidden" name="operation" value="vehicalupdate">
                            <input type="hidden" name="vehicleId" value="<%= vc.getVehicleId() %>">
                            <input type="submit" value="update">
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <footer>
        <p>&copy; 2024 Rent Car System. All rights reserved.</p>
        <a href="terms.jsp">Terms of Service</a> | 
        <a href="privacy.jsp">Privacy Policy</a>
    </footer>
</body>
</html>
