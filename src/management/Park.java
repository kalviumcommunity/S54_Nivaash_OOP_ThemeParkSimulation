package management;

import entities.Ride;
import entities.Visitor;
import entities.Staff;
import entities.ParkFacility;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Ride> rides;
    private List<Visitor> visitors;
    private List<Staff> staffMembers;
    private List<ParkFacility> facilities;

    // Static variables to track total rides and visitors in the park
    private static int totalRides = 0;
    private static int totalVisitors = 0;

    // Constructor to initialize park with empty lists for rides, visitors, etc.
    public Park() {
        this.rides = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.facilities = new ArrayList<>();
    }

    // Method to add a ride to the park
    public void addRide(Ride ride) {
        rides.add(ride);
        totalRides++;  // Increment the static total rides counter
        System.out.println("Ride added: " + ride.getRideName());
    }

    // Method to add a visitor to the park
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
        totalVisitors++;  // Increment the static total visitors counter
        System.out.println("Visitor added: " + visitor.getName());
    }

    // Method to simulate a day in the park where all rides operate and calculate revenue
    public void simulateDay() {
        System.out.println("Starting simulation for the day...");

        // Each ride is run once and revenue is generated
        for (Ride ride : rides) {
            ride.operate();
        }

        System.out.println("Simulation complete.");
    }

    // Method to calculate total revenue earned by the park
    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;

        // Add revenue from each ride
        for (Ride ride : rides) {
            totalRevenue += ride.getTotalRevenue();
        }

        System.out.println("Total revenue generated: " + totalRevenue);
        return totalRevenue;
    }

    // Static method to get the total number of rides added to the park
    public static int getTotalRides() {
        return totalRides;
    }

    // Static method to get the total number of visitors in the park
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    // Method to add a staff member to the park
    public void addStaff(Staff staff) {
        staffMembers.add(staff);
        System.out.println("Staff member added: " + staff.getName());
    }

    // Method to add a facility (e.g., food court, restroom, etc.) to the park
    public void addFacility(ParkFacility facility) {
        facilities.add(facility);
        System.out.println("Facility added: " + facility.getFacilityName());
    }

    // Method to display information about the park
    public void displayParkInfo() {
        System.out.println("Park Information:");
        System.out.println("Total Rides: " + getTotalRides());
        System.out.println("Total Visitors: " + getTotalVisitors());
        System.out.println("Number of Staff: " + staffMembers.size());
        System.out.println("Number of Facilities: " + facilities.size());
    }
}
