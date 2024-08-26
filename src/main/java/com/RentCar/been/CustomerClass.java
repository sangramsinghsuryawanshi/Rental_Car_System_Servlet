package com.RentCar.been;

public class CustomerClass 
{
	 private int customerId;
	 private String name;
	 private String email;
	 private String phone;
	 private String password;
	 private String user_type;
	
	public CustomerClass(int customerId, String name, String email, String phone, String password, String user_type) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.user_type = user_type;
	}
	public CustomerClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "CustomerClass [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", user_type=" + user_type + "]";
	}
}
