package entities;

public class Ride {
    private String name;
    private String location;
    private int capacity;
    private int thrillLevel;
    private int maintenanceInterval;
    private int lastMaintenanceDay;

    public Ride(String name, String location, int capacity, int thrillLevel, int maintenanceInterval) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.thrillLevel = thrillLevel;
        this.maintenanceInterval = maintenanceInterval;
        this.lastMaintenanceDay = 0; // Assume the park starts on day 0
    }

    public boolean isDueForMaintenance(int currentDay) {
        return (currentDay - lastMaintenanceDay) >= maintenanceInterval;
    }

    public void performMaintenance(int currentDay) {
        lastMaintenanceDay = currentDay;
        System.out.println(name + " has been maintained.");
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Ride: " + name + ", Location: " + location +
                ", Capacity: " + capacity + ", Thrill Level: " + thrillLevel);
    }
}
