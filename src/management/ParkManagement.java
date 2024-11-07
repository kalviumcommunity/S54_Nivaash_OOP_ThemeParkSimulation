package management;

import attractions.ParkAttraction;

import java.util.ArrayList;
import java.util.List;

public class ParkManagement {
    private List<ParkAttraction> attractions;

    public ParkManagement() {
        this.attractions = new ArrayList<>();
    }

    // Method to add an attraction (either Ride or Show)
    public void addAttraction(ParkAttraction attraction) {
        attractions.add(attraction);
        System.out.println("Attraction added: " + attraction.getName());
    }

    // Method to simulate a day in the park by operating all attractions
    public void simulateDay() {
        System.out.println("Starting simulation for the day...");
        for (ParkAttraction attraction : attractions) {
            attraction.operate();
        }
        System.out.println("Simulation complete.");
    }

    // Method to display all attractions in the park
    public void displayAttractions() {
        System.out.println("Attractions in the Park:");
        for (ParkAttraction attraction : attractions) {
            System.out.println(attraction);
        }
    }
}
