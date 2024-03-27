package assignementclassandobjects;

public class Flight {
    private static int noOfWheels;
    private static int noOfWings;
    private String name;
    private int noOfSeats;
    private String departure;
    private String arrival;

    public static int getNoOfWheels() {
        return noOfWheels;
    }

    public static void setNoOfWheels(int noOfWheels) {
        Flight.noOfWheels = noOfWheels;
    }

    public static int getNoOfWings() {
        return noOfWings;
    }

    public static void setNoOfWings(int noOfWings) {
        Flight.noOfWings = noOfWings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }


}
