package management;

import entities.Ride;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Ride> rides;
    private int currentDay;
    private static int totalVisitors;
    private static double totalIncome;

    public Park() {
        this.rides = new ArrayList<>();
        this.currentDay = 0;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void simulateDay() {
        System.out.println("Day " + currentDay + " Simulation Start");

        for (Ride ride : rides) {
            if (ride.isDueForMaintenance(currentDay)) {
                ride.performMaintenance(currentDay);
            }
        }

        // Example of incrementing total income
        totalIncome += rides.size() * 100; // Assuming each ride generates $100 per day

        currentDay++;
        System.out.println("Day " + currentDay + " Simulation End\n");
    }

    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static double getTotalIncome() {
        return totalIncome;
    }
}
