package com.eventplanner;
import java.util.Scanner;


public class LoginMenu {
    
    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);
        User currentUser;
        System.out.println("Please input your Email:");
        String email = scanner.next();
        System.out.println("Please input your Password:");
        String password = scanner.next();

        for(User x : Database.users){
            if(x.getEmail() == email && x.getPassword() == password){
                currentUser = x;
                if(currentUser.getRole() == Role.ADMIN){
                    AdminMenu.adminMenu(currentUser);
                    scanner.close();
                    break;
                }
                if(currentUser.getRole() == Role.ORGANIZER){
                    OrganizerMenu.organizerMenu(currentUser);
                    scanner.close();
                    break;
                }
                else{
                    AttendeeMenu.attendeeMenu(currentUser);
                    scanner.close();
                    break;
                }
            }
            else{
                System.out.println("User not found.");
                scanner.close();
                return;
            }
        }
    }
}
