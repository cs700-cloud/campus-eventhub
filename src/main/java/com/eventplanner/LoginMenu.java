package com.eventplanner;
import java.util.Scanner;


public class LoginMenu {

    public static void loginMenu(Scanner scanner) {

        System.out.println("Please input your Email:");
        String email = scanner.nextLine().trim();

        System.out.println("Please input your Password:");
        String password = scanner.nextLine().trim();

        for (User x : Database.users) {

            if (x.getEmail().equals(email) &&
                x.getPassword().equals(password)) {

                if (x.getRole() == Role.ADMIN) {
                    AdminMenu.adminMenu(x, scanner);
                }

                else if (x.getRole() == Role.ORGANIZER) {
                    OrganizerMenu.organizerMenu(x, scanner);
                }

                else {
                    AttendeeMenu.attendeeMenu(x, scanner);
                }

                return;
            }
        }

        System.out.println("User not found.");
    }
}