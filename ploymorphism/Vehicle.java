package ploymorphism;

abstract public class Vehicle {
    private String brand;
    private String fuelType;
    private int noOfWheels;
    private String cc;

    public Vehicle(String brand, String fuelType, int noOfWheels, String cc) {
        this.brand = brand;
        this.fuelType = fuelType;
        this.noOfWheels = noOfWheels;
        this.cc=cc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getfuelType() {
        return fuelType;
    }

    public void setType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public String getC() {
        return cc;
    }

    public void setCc(String hp) {
        this.cc = cc;
    }
    public abstract void start();

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", noOfWheels=" + noOfWheels +
                ", cc='" + cc + '\'' +
                '}';
    }
}
class Bus extends Vehicle{
    public Bus(String brand, String type, int noOfWheels, String hp) {
        super(brand, type, noOfWheels, hp);
    }
    public void start(){
        System.out.println("Bus starts");
    }
    public void stop(){
        System.out.println("Bus stops");
    }
}
class Car extends Vehicle {
    public Car(String brand, String type, int noOfWheels, String hp) {
        super(brand, type, noOfWheels, hp);
    }
    public void start(){
        System.out.println("Car starts");
    }
    public void stop(){
        System.out.println("Car stops");
    }
}
class Bike extends Vehicle{
    public Bike(String brand, String type, int noOfWheels, String hp) {
        super(brand, type, noOfWheels, hp);
    }
    public void start(){
        System.out.println("Bike starts");
    }
    public void stop(){
        System.out.println("Bike stops");
    }

}

