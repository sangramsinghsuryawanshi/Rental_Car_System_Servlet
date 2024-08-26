package com.RentCar.been;

public class RentalClass 
{
	 private int rentalId;
	 private int vehicleId;
	 private int customerId;
	 private String rentalDate;
	 private String returnDate;
	 private double totalPrice;
	public RentalClass(int rentalId, int vehicleId, int customerId, String rentalDate, String returnDate,
			double totalPrice)
	{
		super();
		this.rentalId = rentalId;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.totalPrice = totalPrice;
	}
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public RentalClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RentalClass [rentalId=" + rentalId + ", vehicleId=" + vehicleId + ", customerId=" + customerId
				+ ", rentalDate=" + rentalDate + ", returnDate=" + returnDate + ", totalPrice=" + totalPrice + "]";
	}
	
	 
}
