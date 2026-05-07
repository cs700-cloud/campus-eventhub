package com.eventplanner;
import java.util.Scanner;

public class AttendeeMenu {

    public static void attendeeMenu(User user) {

        User currentUser = user;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("\n=== Attendee Menu ===");
            System.out.println("1. Browse Events");
            System.out.println("2. Register");
            System.out.println("3. QR Check-In");
            System.out.println("4. Back");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    EventManager.viewEvents();
                    break;

                case 2:
                    register(currentUser);
                    break;

                case 3:
                    qrCheckIn();
                    break;

                case 4:
                    return;
            }
        }
    }
}