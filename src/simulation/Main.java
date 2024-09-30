package simulation;

import entities.Ride;
import management.Park;

import java.util.Scanner;

public class Main {
    private static Park park = new Park();
    private static Scanner scanner = new Scanner(System.in);
    private static Ride[] rides = new Ride[20]; // Array to hold up to 20 Ride objects
    private static int rideCount = 0; // Counter to keep track of number of rides added

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();
            handleUserChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Virtual Theme Park Simulator ---");
        System.out.println("1. Add Ride");
        System.out.println("2. Simulate Day");
        System.out.println("3. View Park Summary");
        System.out.println("4. Show all the rides");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayRides() {
        for (int i = 0; i < rideCount; i++) {
            System.out.println("Ride " + (i + 1) + ": " + rides[i].getName());
        }
    }


    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addRide();
                break;
            case 2:
                simulateDay();
                break;
            case 3:
                viewParkSummary();
                break;
            case 4:
                displayRides();
                break;
            case 5:
                exitSimulator();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addRide() {
        if (rideCount >= rides.length) {
            System.out.println("Cannot add more rides. The array is full.");
            return;
        }

        System.out.print("Enter Ride Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Ride Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("Enter Thrill Level (1-5): ");
        int thrillLevel = scanner.nextInt();
        System.out.print("Enter Maintenance Interval (in days): ");
        int maintenanceInterval = scanner.nextInt();

        Ride ride = new Ride(name, location, capacity, thrillLevel, maintenanceInterval);
        rides[rideCount++] = ride; // Add ride to the array
        park.addRide(ride);
        System.out.println("Ride added successfully!");
    }

    private static void simulateDay() {
        park.simulateDay();
    }

    private static void viewParkSummary() {
        System.out.println("\n--- Park Summary ---");
        System.out.println("Total Income: $" + Park.getTotalIncome());
    }

    private static void exitSimulator() {
        System.out.println("Exiting the simulator. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
