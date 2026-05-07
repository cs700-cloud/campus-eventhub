package com.eventplanner;
import java.util.Scanner;


public class OrganizerMenu {
     public static void organizerMenu(User user) {
        User currentUser = user;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("\n=== Organizer Menu ===");
            System.out.println("1. Create Event");
            System.out.println("2. View My Events");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    EventManager.createEvent(currentUser);
                    scanner.close();
                    break;

                case 2:
                    EventManager.viewEvents();
                    scanner.close();
                    break;

                case 3:
                    scanner.close();
                    return;
            }
        }
    }

}
