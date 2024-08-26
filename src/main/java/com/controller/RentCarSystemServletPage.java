package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import com.RentCar.been.ContactClass;
import com.RentCar.been.CustomerClass;
import com.RentCar.been.VehicalClass;
import com.RentCar.dao.QueryConnections;

/**
 * Servlet implementation class RentCarSystemServletPage
 */
@WebServlet("/RentCarSystemServletPage")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
    maxFileSize = 1024 * 1024 * 10,      // 10 MB
    maxRequestSize = 1024 * 1024 * 50    // 50 MB
)
public class RentCarSystemServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentCarSystemServletPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false); 
	        if (session != null) 
	        {
	            session.invalidate(); 
	        }
	        response.sendRedirect("login.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			String oper = request.getParameter("operation");
			if(oper.equals("register"))
			{
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String phone=request.getParameter("phone");
				String password=request.getParameter("password");
				String userType=request.getParameter("user_type");
				CustomerClass cob = new CustomerClass();
				cob.setName(name);
				cob.setEmail(email);
				cob.setPhone(phone);
				cob.setPassword(password);
				cob.setUser_type(userType);
				if(QueryConnections.isCreated(cob)!=0)
				{
					pw.print("<script>alert('Registerd successfully!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
				else
				{
					pw.print("<script>alert('Data is not Registerd!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
					rd.include(request, response);
				}
			}
			else if(oper.equals("login"))
			{
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				CustomerClass cob = new CustomerClass();
				cob.setEmail(email);
				cob.setPassword(password);
				String usertype=QueryConnections.isLogin(cob);
				if(usertype!=null)
				{
					HttpSession session = request.getSession();
			        session.setAttribute("user", cob); 
			        session.setAttribute("user_type", usertype);

					if(usertype.equals("admin"))
					{
						RequestDispatcher rd = request.getRequestDispatcher("admin_home.jsp");
						rd.include(request, response);
					}
					else if(usertype.equals("user"))
					{
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						rd.include(request, response);
					}
	            }
	            else
	            {
	            	pw.print("<script>alert('Login Failed...! Username or Password is incorrect.');window.location.replace('login.jsp');</script>");
	            }
			}
			else if (oper.equals("addVehicle"))
			{
			    String make = request.getParameter("make");
			    String model = request.getParameter("model");
			    int year = Integer.parseInt(request.getParameter("year"));
			    double price = Double.parseDouble(request.getParameter("price"));
			    String description = request.getParameter("description");
			    
			    Part filePart = request.getPart("imagePath");
			    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			    String uploadDir = getServletContext().getRealPath("") + File.separator + "VehicalImages";
			    File uploadDirFile = new File(uploadDir);
			    
			    if (!uploadDirFile.exists())
			    {
			        uploadDirFile.mkdir();
			    }
			    
			    String uploadPath = uploadDir + File.separator + fileName;

			    try
			    {
			        filePart.write(uploadPath);
			    }
			    catch (IOException e)
			    {
			        e.printStackTrace();
			        pw.print("<script>alert('File upload failed.');</script>");
			        return;
			    }

			    VehicalClass vc = new VehicalClass();
			    vc.setMake(make);
			    vc.setModel(model);
			    vc.setYear(year);
			    vc.setPrice(price);
			    vc.setDescription(description);
			    vc.setImagePath(fileName);

			    if (QueryConnections.isVehiInsert(vc) != 0) 
			    {
			        request.setAttribute("message", "Vehicle data inserted successfully.");
			    }
			    else 
			    {
			        request.setAttribute("message", "Vehicle data not inserted.");
			    }
			    RequestDispatcher rd = request.getRequestDispatcher("admin_vehicle.jsp");
			    rd.forward(request, response);
			}
			else if(oper.equals("userdelete"))
			{
				int cid=Integer.parseInt(request.getParameter("customerId"));
				if(QueryConnections.isDelete(cid)!=0)
				{
					pw.print("<script>alert('User Data Deleted Successfully!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("user_data.jsp");
					rd.include(request, response);
				}
				else
				{
					pw.print("<script>alert('User Data Not Deleted..!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("user_data.jsp");
					rd.include(request, response);
				}
			}
			
			else if(oper.equals("vehicaldelete"))
			{
				int cid=Integer.parseInt(request.getParameter("vehicleId"));
				if(QueryConnections.isVehicalDelete(cid)!=0)
				{
					pw.print("<script>alert('Vehical Data Deleted Successfully!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("admin_vehicle.jsp");
					rd.include(request, response);
				}
				else
				{
					pw.print("<script>alert('Vehical Data Not Deleted..!!');</script>");
					RequestDispatcher rd = request.getRequestDispatcher("admin_vehicle.jsp");
					rd.include(request, response);
				}
			}
			if(oper.equals("contact"))
			{
				String uname=request.getParameter("uname");
				String uemail=request.getParameter("uemail");
				String usubject=request.getParameter("usubject");
				String umessage=request.getParameter("umessage");
				ContactClass cob = new ContactClass();
				cob.setUname(uname);
				cob.setUemail(uemail);
				cob.setUsubject(usubject);
				cob.setUmessage(umessage);
				if(QueryConnections.isContact(cob)!=0)
				{
					request.setAttribute("message", "Message Sent successfully!!");
					RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
					rd.include(request, response);
				}
				else
				{
					request.setAttribute("message", "Message Not Sent successfully!!");
					RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
					rd.include(request, response);
				}
			}
			
			else if (oper.equals("vehicalupdate")) 
			{
			    int cid = Integer.parseInt(request.getParameter("vehicleId"));
			    VehicalClass vehicle = QueryConnections.getVehicleById(cid); // Fetch vehicle details

			    if (vehicle != null) 
			    {
			        request.setAttribute("vehicle", vehicle); // Set the vehicle as a request attribute
			        RequestDispatcher rd = request.getRequestDispatcher("vehicalupdate.jsp");
			        rd.forward(request, response);
			    } 
			    else 
			    {
			        pw.print("<script>alert('Failed to retrieve vehicle details..!!');</script>");
			        RequestDispatcher rd = request.getRequestDispatcher("admin_vehicle.jsp");
			        rd.include(request, response);
			    }
			}
			
			else if (oper.equals("saveUpdatedVehicle")) 
			{
			    int cid = Integer.parseInt(request.getParameter("vehicleId"));
			    VehicalClass vehicle = new VehicalClass();

			    vehicle.setVehicleId(cid);
			    vehicle.setMake(request.getParameter("make"));
			    vehicle.setModel(request.getParameter("model"));
			    vehicle.setYear(Integer.parseInt(request.getParameter("year")));
			    vehicle.setPrice(Double.parseDouble(request.getParameter("price")));
			    vehicle.setDescription(request.getParameter("description"));

			    Part imagePart = request.getPart("imagePath");
			    if (imagePart != null && imagePart.getSize() > 0) 
			    {
			        String imageName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
			        String imagePath = "VehicalImages/" + imageName;
			        vehicle.setImagePath(imagePath);
			        
			        imagePart.write(getServletContext().getRealPath("/") + imagePath);
			    }

			    if (QueryConnections.isVehicalUpdate(vehicle) != 0) 
			    {
			        pw.print("<script>alert('Vehicle updated successfully!');</script>");
			    } 
			    else 
			    {
			        pw.print("<script>alert('Failed to update vehicle.');</script>");
			    }
			    RequestDispatcher rd = request.getRequestDispatcher("admin_vehicle.jsp");
			    rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}
}
