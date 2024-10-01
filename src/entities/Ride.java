package entities;

import java.util.Random;

public class Ride {
    private String name;
    private int capacity;
    private int duration; // in seconds
    private int thrillLevel;
    private boolean open;
    private double ticketPrice; // Price per visitor
    private int totalRidesServed; // Total number of rides served
    private double totalRevenue; // Total revenue generated

    public Ride(String name, int capacity, int duration, int thrillLevel, double ticketPrice) {
        this.name = name;
        this.capacity = capacity;
        this.duration = duration;
        this.thrillLevel = thrillLevel;
        this.open = true; // rides are open by default
        this.ticketPrice = ticketPrice;
        this.totalRidesServed = 0;
        this.totalRevenue = 0;
    }

    public String getRideName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDuration() {
        return duration;
    }

    public int getThrillLevel() {
        return thrillLevel;
    }

    public boolean isOpen() {
        return open;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void close() {
        this.open = false;
    }

    // Method to simulate the operation of the ride
    public void operate() {
        if (open) {
            // Simulate serving visitors randomly between 1 and capacity
            Random random = new Random();
            int numberOfVisitors = random.nextInt(capacity) + 1; // Random visitors from 1 to capacity
            serveRide(numberOfVisitors); // Call serveRide to update the total rides and revenue
        } else {
            System.out.println("Ride " + name + " is closed.");
        }
    }

    public void serveRide(int numberOfVisitors) {
        if (numberOfVisitors > capacity) {
            numberOfVisitors = capacity; // Serve only up to capacity
        }
        totalRidesServed++;
        totalRevenue += numberOfVisitors * ticketPrice; // Calculate revenue for this ride

        // Print the operation details
        System.out.println("Ride " + name + " operated for " + duration + " seconds, serving " + numberOfVisitors + " visitors and generating revenue of " + (numberOfVisitors * ticketPrice));
    }

    @Override
    public String toString() {
        return "Ride Name: " + name + ", Capacity: " + capacity + ", Duration: " + duration + " seconds, Thrill Level: " + thrillLevel +
                ", Total Revenue: " + totalRevenue + " (Open: " + (open ? "Yes" : "No") + ")";
    }
}
