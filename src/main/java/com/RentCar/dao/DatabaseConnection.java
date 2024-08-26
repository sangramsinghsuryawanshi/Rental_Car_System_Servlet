package com.RentCar.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection 
{
	public static Connection isConnect()
	{
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/RentalCarSystem","root","12345");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}
