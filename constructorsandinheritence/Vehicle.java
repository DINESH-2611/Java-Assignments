package constructorsandinheritence;
public class Vehicle {
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
}
class Car extends Vehicle{
    public Car(String brand, String type, int noOfWheels, String hp) {
        super(brand, type, noOfWheels, hp);
    }
}
class Bike extends Vehicle{
    public Bike(String brand, String type, int noOfWheels, String hp) {
        super(brand, type, noOfWheels, hp);
    }

}
class vehicleDriver{
    public static void main(String[] args) {
        Vehicle vehicle1=new Bus("Tata","Diesel",4,"5800cc");
        Vehicle vehicle2=new Car("Rolls royce","Diesel",4,"6700cc");
        Vehicle vehicle3=new Bike("RE","Petrol",2,"500cc");
        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println(vehicle3);
    }
}
