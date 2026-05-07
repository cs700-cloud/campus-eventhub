package com.eventplanner;
import java.util.Scanner;


public class AdminMenu {
    public static void adminMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Venue");
            System.out.println("2. View Events");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addVenue();
                    break;

                case 2:
                    viewEvents(user);
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}
