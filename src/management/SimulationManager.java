package management;

import attractions.ParkAttraction;

import java.util.List;

public class SimulationManager {
    private List<ParkAttraction> attractions;

    public SimulationManager(List<ParkAttraction> attractions) {
        this.attractions = attractions;
    }

    public void simulateDay() {
        System.out.println("Starting simulation for the day...");
        for (ParkAttraction attraction : attractions) {
            operateAttraction(attraction);
        }
        System.out.println("Simulation complete.");
    }

    private void operateAttraction(ParkAttraction attraction) {
        attraction.operate(); // Liskov Substitution: Any subclass can use this method.
    }
}
