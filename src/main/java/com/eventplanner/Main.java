package com.eventplanner;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        User adminAccount = new User(1, "admin", "admin@nyu.edu", "12345", Role.ADMIN);
        User organizerAccount = new User(2, "organizer", "organizer@nyu.edu", "12345", Role.ORGANIZER);
        User attendeeAccount = new User(3, "attendee", "attendee@nyu.edu", "12345", Role.ATTENDEE);
        Database.users.add(adminAccount); Database.users.add(organizerAccount); Database.users.add(attendeeAccount);
        while (true) {

            System.out.println("\n=== Campus EventHub ===");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    LoginMenu.loginMenu();
                    break;

                case 2:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}