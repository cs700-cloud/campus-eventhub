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
                    System.out.println("Please input the ID of the event you wish to register for:");
                    int eventID = scanner.nextInt();
                    Event desiredEvent = null;
                    for(Event e : Database.events){
                        if(e.getID() == eventID){
                            desiredEvent = e;
                            break;
                        }
                    }
                    if(desiredEvent == null){
                        System.out.println("Event ID not found. Please try again.");
                        break;
                    }

                    RegistrationManager.registerForEvent(currentUser, desiredEvent);
                    break;

                case 3:
                    EventManager.qrCheckIn(currentUser);
                    break;

                case 4:
                    scanner.close();
                    return;
            }
        }
    }
}