package simulation;

import entities.Ride;
import entities.Visitor;
import entities.Staff;
import entities.ParkFacility;
import management.Park;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Park park;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Initialize park and scanner for user input
        park = new Park();
        scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\nWelcome to the Virtual Theme Park Simulator!");
            System.out.println("1. Add Ride");
            System.out.println("2. Add Visitor");
            System.out.println("3. Add Staff");
            System.out.println("4. Add Facility");
            System.out.println("5. Simulate Day");
            System.out.println("6. Display Park Info");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1-7): ");

            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    addRide();
                    break;
                case 2:
                    addVisitor();
                    break;
                case 3:
                    addStaff();
                    break;
                case 4:
                    addFacility();
                    break;
                case 5:
                    simulateDay();
                    break;
                case 6:
                    park.displayParkInfo();
                    break;
                case 7:
                    System.out.println("Exiting the simulator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to get a valid choice from user input
    private static int getValidChoice() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    // Method to add a ride based on user input
    private static void addRide() {
        System.out.print("Enter ride name: ");
        String name = scanner.nextLine();
        int capacity = getValidInteger("Enter ride capacity: ");
        int duration = getValidInteger("Enter ride duration (seconds): ");
        int thrillLevel = getValidInteger("Enter thrill level (1-10): ");
        double ticketPrice = getValidDouble("Enter ticket price: ");

        // Create a new ride object
        Ride ride = new Ride(name, capacity, duration, thrillLevel, ticketPrice);
        park.addRide(ride);
    }

    // Method to add a visitor based on user input
    private static void addVisitor() {
        System.out.print("Enter visitor name: ");
        String name = scanner.nextLine();
        int age = getValidInteger("Enter age: ");

        // Create a new visitor object
        Visitor visitor = new Visitor(name);
        park.addVisitor(visitor);
    }

    // Method to add staff based on user input
    private static void addStaff() {
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();
        double salary = getValidDouble("Enter staff salary: ");

        // Create a new staff object
        Staff staff = new Staff(name, role, salary);
        park.addStaff(staff);
    }

    // Method to add a facility based on user input
    private static void addFacility() {
        System.out.print("Enter facility name: ");
        String name = scanner.nextLine();
        System.out.print("Enter facility type (e.g., restroom, food court): ");
        String type = scanner.nextLine();

        // Create a new park facility object
        ParkFacility facility = new ParkFacility(name, type);
        park.addFacility(facility);
    }

    // Method to simulate a day in the park
    private static void simulateDay() {
        park.simulateDay();
        park.calculateTotalRevenue();
    }

    // Helper method to get a valid integer input
    private static int getValidInteger(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    // Helper method to get a valid double input
    private static double getValidDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
