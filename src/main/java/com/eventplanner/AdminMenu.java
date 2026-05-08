package com.eventplanner;
import java.util.Scanner;


public class AdminMenu {
    public static void adminMenu(User user, Scanner scanner) {
        while (true) {

            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Venue");
            System.out.println("2. View Events");
            System.out.println("3. List Venues");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Please input the ID of the venue you wish to create:");
                    int venueID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please input the name of your venue:");
                    String name = scanner.nextLine();
                    System.out.println("Please input the capacity of your venue:");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    String[] equipment = new String[20];
                    Venue newVenue = new Venue(venueID, name, capacity, equipment);
                    VenueManager.addVenue(user, newVenue);
                    break;

                case 2:
                    EventManager.viewEvents();
                    break;

                case 3:
                    VenueManager.listVenues();
                    break;

                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}
