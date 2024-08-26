<%@page import="com.RentCar.dao.QueryConnections"%>
<%@page import="com.RentCar.been.CustomerClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Data</title>
<link rel="stylesheet" type="text/css" href="css/userdata.css">
</head>
<body>
	 <header>
        <a href="admin_home.jsp">Home</a>
        <a href="admin_vehicle.jsp">Vehicles</a>
        <a href="user_data.jsp">User Data</a>
        <a href="RentCarSystemServletPage">Logout</a>
    </header>
   
    <table>
    	<tr>
    		<th>Customer Id</th>
    		<th>Customer Name</th>
    		<th>Customer Email</th>
    		<th>Customer Phone</th>
    		<th>Customer Password</th>
    		<th>Customer User Type</th>
    		<th>Delete User</th>
    	</tr>
    	 <%
    		List<CustomerClass> li = QueryConnections.isUserFetch();
    	 	for(CustomerClass cob:li)
    	 	{
    	%>
    		<tr>
    			<td><%=cob.getCustomerId() %></td>
    			<td><%=cob.getName() %></td>
    			<td><%=cob.getEmail() %></td>
    			<td><%=cob.getPhone() %></td>
    			<td><%=cob.getPassword() %></td>
    			<td><%=cob.getUser_type() %></td>
    			<td>
                     <form action="RentCarSystemServletPage" method="post">
                     <input type="hidden" name="operation" value="userdelete">
                     <input type="hidden" name="customerId" value="<%= cob.getCustomerId() %>">
                     <input class="button1" type="submit" value="Delete">
                     </form>
                </td>
    		</tr>
    	<%} %>
    </table>
     <footer>
        <p>&copy; 2024 Rent Car System. All rights reserved.</p>
        <a href="terms.jsp">Terms of Service</a> | 
        <a href="privacy.jsp">Privacy Policy</a>
    </footer>
</body>
</html>