package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletLogin() {
        // Default constructor
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("password");

        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/org", "root", "12345");

            // Query to check if the user exists with the provided username and password
            PreparedStatement ps = con.prepareStatement("SELECT * FROM User");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) 
            {
            	if(name==rs.getString(1) && pass == rs.getString(2))
            	{
            		pw.print("<script>alert('Login Successful...!');window.location.replace('login.html');</script>");
            	}
            	else
            	{
            		pw.print("<script>alert('Login Failed...! Username or Password is incorrect.');window.location.replace('index.html');</script>");
            	}
            }

            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
