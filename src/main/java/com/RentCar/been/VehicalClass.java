package com.RentCar.been;

public class VehicalClass {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private double price;
    private String description;
    private String imagePath;

    public VehicalClass(int vehicleId, String make, String model, int year, double price, String description, String imagePath) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public VehicalClass() {
        super();
    }

    @Override
    public String toString() {
        return "VehicleClass [vehicleId=" + vehicleId + ", make=" + make + ", model=" + model + ", year=" + year
                + ", price=" + price + ", description=" + description + ", imagePath=" + imagePath + "]";
    }
}
