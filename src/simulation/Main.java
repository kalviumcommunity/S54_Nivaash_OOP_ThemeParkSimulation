package simulation;

import entities.Ride;
import management.Park;

import java.util.Scanner;

public class Main {
    private static Park park = new Park();
    private static Scanner scanner = new Scanner(System.in);

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
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
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
                exitSimulator();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addRide() {
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
        park.addRide(ride);
        System.out.println("Ride added successfully!");
    }

    private static void simulateDay() {
        park.simulateDay();
    }

    private static void viewParkSummary() {
        System.out.println("\n--- Park Summary ---");
        System.out.println("Total Income: $" + Park.getTotalIncome());
        // You can add more details here if needed
    }

    private static void exitSimulator() {
        System.out.println("Exiting the simulator. Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
