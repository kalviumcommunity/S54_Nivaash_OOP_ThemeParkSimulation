package simulation;

import attractions.RideAttraction;
import attractions.ShowAttraction;
import management.ParkManagement;

import java.util.Scanner;

public class Main {
    private static ParkManagement parkManagement;
    private static Scanner scanner;

    public static void main(String[] args) {
        parkManagement = new ParkManagement();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Virtual Theme Park Simulator!");
            System.out.println("1. Add Ride Attraction");
            System.out.println("2. Add Show Attraction");
            System.out.println("3. Simulate Day");
            System.out.println("4. Display All Attractions");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addRideAttraction();
                    break;
                case 2:
                    addShowAttraction();
                    break;
                case 3:
                    parkManagement.simulateDay();
                    break;
                case 4:
                    parkManagement.displayAttractions();
                    break;
                case 5:
                    System.out.println("Exiting the simulator. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addRideAttraction() {
        System.out.print("Enter ride name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ride capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter ride duration (seconds): ");
        int duration = scanner.nextInt();

        System.out.print("Enter ticket price: ");
        double ticketPrice = scanner.nextDouble();

        RideAttraction ride = new RideAttraction(name, capacity, duration, ticketPrice);
        parkManagement.addAttraction(ride);

        System.out.println("Ride attraction successfully added!");
    }

    private static void addShowAttraction() {
        System.out.print("Enter show name: ");
        String name = scanner.nextLine();

        System.out.print("Enter show duration (minutes): ");
        int duration = scanner.nextInt();

        System.out.print("Enter seating capacity: ");
        int seatingCapacity = scanner.nextInt();

        System.out.print("Enter ticket price for the show: ");
        double ticketPrice = scanner.nextDouble();

        ShowAttraction show = new ShowAttraction(name, duration, seatingCapacity, ticketPrice);
        parkManagement.addAttraction(show);

        System.out.println("Show attraction successfully added!");
    }
}
