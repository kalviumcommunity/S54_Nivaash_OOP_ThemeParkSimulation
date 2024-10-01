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

        park = new Park();
        scanner = new Scanner(System.in);

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

    private static int getValidChoice() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine();
            }
        }
    }

    private static void addRide() {
        scanner.nextLine();

        System.out.print("Enter ride name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ride capacity: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        int capacity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter ride duration (seconds): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
        }
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter thrill level (1-10): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer between 1 and 10.");
            scanner.next();
        }
        int thrillLevel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter ticket price: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid ticket price.");
            scanner.next();
        }
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();

        Ride ride = new Ride(name, capacity, duration, thrillLevel, ticketPrice);
        park.addRide(ride);

        System.out.println("Ride successfully added!");
    }




    private static void addVisitor() {
        scanner.nextLine();

        System.out.print("Enter visitor name: ");
        String name = scanner.nextLine();

        int age = getValidInteger("Enter age: ");

        Visitor visitor = new Visitor(name);
        park.addVisitor(visitor);

        System.out.println("Visitor successfully added!");
    }


    private static void addStaff() {
        scanner.nextLine();

        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();

        System.out.print("Enter staff role: ");
        String role = scanner.nextLine();

        double salary = getValidDouble("Enter staff salary: ");

        // Create a new staff object
        Staff staff = new Staff(name, role, salary);
        park.addStaff(staff);

        System.out.println("Staff successfully added!");
    }


    private static void addFacility() {
        scanner.nextLine();

        System.out.print("Enter facility name: ");
        String name = scanner.nextLine();

        System.out.print("Enter facility type (e.g., restroom, food court): ");
        String type = scanner.nextLine();

        ParkFacility facility = new ParkFacility(name, type);
        park.addFacility(facility);

        System.out.println("Facility successfully added!");
    }


    private static void simulateDay() {
        park.simulateDay();
        park.calculateTotalRevenue();
    }


    private static int getValidInteger(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

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
