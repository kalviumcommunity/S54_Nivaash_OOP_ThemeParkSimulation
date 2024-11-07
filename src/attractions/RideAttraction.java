package attractions;

import java.util.Random;

public class RideAttraction extends ParkAttraction {
    private int capacity;
    private int duration; // in seconds
    private double ticketPrice;
    private int totalRidesServed;
    private double totalRevenue;

    public RideAttraction(String name, int capacity, int duration, double ticketPrice) {
        super(name); // Call to the parent constructor
        this.capacity = capacity;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
        this.totalRidesServed = 0;
        this.totalRevenue = 0;
    }

    @Override
    public void operate() {
        if (open) {
            Random random = new Random();
            int numberOfVisitors = random.nextInt(capacity) + 1;
            serveRide(numberOfVisitors);
        } else {
            System.out.println("Ride " + name + " is closed.");
        }
    }

    private void serveRide(int numberOfVisitors) {
        totalRidesServed++;
        double rideRevenue = numberOfVisitors * ticketPrice;
        totalRevenue += rideRevenue;
        System.out.println("Ride " + name + " operated, serving " + numberOfVisitors + " visitors and generating revenue of " + rideRevenue);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}
