package com.RentCar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RentCar.been.ContactClass;
import com.RentCar.been.CustomerClass;
import com.RentCar.been.VehicalClass;

public class QueryConnections 
{
	public static int isCreated(CustomerClass cob)
	{
		int status=0;
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="insert into customer(name,email,phone,password,user_type)values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cob.getName());
			ps.setString(2,cob.getEmail());
			ps.setString(3,cob.getPhone());
			ps.setString(4,cob.getPassword());
			ps.setString(5,cob.getUser_type());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static String isLogin(CustomerClass cob)
	{
		String userType=null;
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="select user_type from customer where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cob.getEmail());
			ps.setString(2,cob.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				userType=rs.getString("user_type");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userType;
	}
	
	
	
	public static CustomerClass access(String email)
	{
		CustomerClass ob=new CustomerClass();
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="select * from customer where email='"+email+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ob.setCustomerId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setEmail(rs.getString(3));
				ob.setPhone(rs.getString(4));
				ob.setPassword(rs.getString(5));
				ob.setUser_type(rs.getString(6));
			}		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ob;
	}
	
	public static int isVehiInsert(VehicalClass vc)
	{
		int status=0;
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="insert into vehicle(make,model,year,price,description,imagePath)values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,vc.getMake());
			ps.setString(2,vc.getModel());
			ps.setInt(3,vc.getYear());
			ps.setDouble(4,vc.getPrice());
			ps.setString(5,vc.getDescription());
			ps.setString(6,vc.getImagePath());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static List<CustomerClass> isUserFetch()
	{
		List<CustomerClass> li = new ArrayList<>();
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="select * from customer";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				CustomerClass ob = new CustomerClass();
				ob.setCustomerId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setEmail(rs.getString(3));
				ob.setPhone(rs.getString(4));
				ob.setPassword(rs.getString(5));
				ob.setUser_type(rs.getString(6));
				li.add(ob);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return li;
	}
	public static int isDelete(int id)
	{
		int status=0;
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="delete from customer where customerId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static List<VehicalClass> getAllVehicles() 
	{
	    List<VehicalClass> vehicles = new ArrayList<VehicalClass>();
	    try 
	    {
	        Connection conn = DatabaseConnection.isConnect();
	        String sql = "SELECT * FROM vehicle";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            VehicalClass vc = new VehicalClass();
	            vc.setVehicleId(rs.getInt("vehicleId"));
	            vc.setMake(rs.getString("make"));
	            vc.setModel(rs.getString("model"));
	            vc.setYear(rs.getInt("year"));
	            vc.setPrice(rs.getDouble("price"));
	            vc.setDescription(rs.getString("description"));
	            vc.setImagePath(rs.getString("imagePath"));
	            vehicles.add(vc);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return vehicles;
	}
	
	public static int isVehicalDelete(int id)
	{
		int status=0;
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="delete from vehicle where vehicleId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static int isContact(ContactClass cob)
	{
		int status=0;
		try
		{
			Connection conn = DatabaseConnection.isConnect();
			String sql="insert into contact(uname,uemail,usubject,umessage)values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cob.getUname());
			ps.setString(2,cob.getUemail());
			ps.setString(3,cob.getUsubject());
			ps.setString(4,cob.getUmessage());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static VehicalClass getVehicleById(int vehicleId) 
	{
	    VehicalClass vehicle = null;
	    try 
	    {
	        Connection con = DatabaseConnection.isConnect();
	        String query = "SELECT * FROM vehicle WHERE vehicleId = ?";
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, vehicleId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) 
	        {
	            vehicle = new VehicalClass();
	            vehicle.setVehicleId(rs.getInt("vehicleId"));
	            vehicle.setMake(rs.getString("make"));
	            vehicle.setModel(rs.getString("model"));
	            vehicle.setYear(rs.getInt("year"));
	            vehicle.setPrice(rs.getDouble("price"));
	            vehicle.setDescription(rs.getString("description"));
	            vehicle.setImagePath(rs.getString("imagePath"));
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	    return vehicle;
	}

	public static int isVehicalUpdate(VehicalClass cob)
	{
		int stataus=0;
		try 
		{
			Connection con = DatabaseConnection.isConnect();
			String update = "update vehicle set make=?,model=?,year=?,price=?,description=?,imagePath=? where vehicleId=?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setString(1, cob.getMake());
			ps.setString(2, cob.getModel());
			ps.setInt(3, cob.getYear());
			ps.setDouble(4, cob.getPrice());
			ps.setString(5,cob.getDescription());
			ps.setString(6,cob.getImagePath());
			ps.setInt(7, cob.getVehicleId());
			stataus=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stataus;
	}
}
