package com.eventplanner;
import java.util.Scanner;


public class OrganizerMenu {
     public static void organizerMenu(User user, Scanner scanner) {
        while (true) {

            System.out.println("\n=== Organizer Menu ===");
            System.out.println("1. Create Event");
            System.out.println("2. View Events");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    EventManager.createEvent(user, scanner);
                    break;

                case 2:
                    EventManager.viewEvents();
                    break;

                case 3:
                    return;
            }
        }
    }

}
