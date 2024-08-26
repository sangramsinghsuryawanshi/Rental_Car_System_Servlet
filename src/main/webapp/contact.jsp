<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Contact Us</title>
    <link rel="stylesheet" type="text/css" href="css/contacts.css">
</head>
<body>
    <header>
        <a href="home.jsp">Home</a>
        <a href="vehicaluser.jsp">Vehicles</a>
        <a href="contact.jsp">Contact Us</a>
        <a href="RentCarSystemServletPage">Logout</a>
        <a href="Register.jsp">Register</a>
    </header>

    <div class="form-container">
        <h1>Contact Us</h1>
        <% 
            String message = (String) request.getAttribute("message");
            if (message != null) 
            {
        %>
        <div class="message"><%= message %></div>
        <% } %>

        <form action="RentCarSystemServletPage" method="post">
            <input type="hidden" name="operation" value="contact">
            
            <label for="name">Name</label>
            <input type="text" id="name" name="uname" placeholder="Enter your name" required>
            
            <label for="email">Email</label>
            <input type="email" id="email" name="uemail" placeholder="Enter your email" required>
            
            <label for="subject">Subject</label>
            <input type="text" id="subject" name="usubject" placeholder="Enter subject" required>
            
            <label for="message">Message</label>
            <textarea id="message" name="umessage" placeholder="Enter your message" rows="6" required></textarea>
            
            <input type="submit" value="Send Message">
        </form>
    </div>

    <footer>
        <p>&copy; 2024 Rent Car System. All rights reserved.</p>
        <a href="terms.jsp">Terms of Service</a> | 
        <a href="privacy.jsp">Privacy Policy</a>
    </footer>
</body>
</html>
