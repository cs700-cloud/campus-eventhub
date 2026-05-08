package com.eventplanner;
import java.time.LocalDate;
import java.util.Scanner;

public class EventManager {
    //ORGANIZER METHODS

    public static void createEvent(User user, Scanner scanner){
        System.out.println("Please input the ID of the venue you wish to book:");
        int venueID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please input the date when the event will occur (yyyy-mm-dd):");
        String dateProto = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateProto);
        System.out.println("Please input the name of your event:");
        String name = scanner.nextLine();
        System.out.println("Please input the time your event will begin:");
        String time = scanner.nextLine();

        if(!ConflictDetector.isVenueAvailable(Database.events, venueID, date, time)){
            System.out.println("Timeslot unavailable for venue. Please try another timeslot.");
            return;
        }

        System.out.println("Please input the type of event you will be holding:");
        String type = scanner.nextLine();
        System.out.println("Please input a description of the event you will be holding:");
        String description = scanner.nextLine();
        System.out.println("Please input the capacity of the event you will be holding:");
        int capacity = scanner.nextInt();
        Event newEvent = new Event(venueID, date, name, time, type, description, capacity);
        newEvent.organizerID = user.getId();

        Database.events.add(newEvent);
        
    }

    public void rescheduleEvent(User user, Event event, LocalDate date, String time){
        if(!user.getRole().equals(Role.ORGANIZER)){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        if(!ConflictDetector.isVenueAvailable(Database.events, event.venueID, date, time)){
            System.out.println("Timeslot unavailable for venue. Please try another timeslot.");
            return;
        }
        event.date = date;
        event.time = time;
    }

    public void cancelEvent(User user, Event event){
        if(!user.getRole().equals(Role.ORGANIZER)){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event = null;
    }

    public void changeStatus(User user, Event event, eventStatus status){
        if(!user.getRole().equals(Role.ORGANIZER)){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.status = status;
    }

    public String getAttendees(User user, Event event){
        if(!user.getRole().equals(Role.ORGANIZER)){
            return "You do not have permission to perform this action.";
        }
        return event.attendees.toString();
    }

    public String getWaitlist(User user, Event event){
        if(!user.getRole().equals(Role.ORGANIZER)){
            return "You do not have permission to perform this action.";
        }
        return event.waitlist.toString();
    }

    //ADMIN METHODS
    public void approveEvent(User user, Event event){
        if(!user.getRole().equals(Role.ADMIN)){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.status = eventStatus.PUBLISHED;
    }

    public void rejectEvent(User user, Event event){
        if(!user.getRole().equals(Role.ADMIN)){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.status = eventStatus.REJECTED;
    }

    //BASIC METHODS

    public static void viewEvents(){
        for(Event e : Database.events){
            System.out.println(
                e.getName() + " | " +
                e.getVenueID() + " | " +
                e.getDate()
            );
        }
    }

    public static void qrCheckIn(User user){

    }
}
