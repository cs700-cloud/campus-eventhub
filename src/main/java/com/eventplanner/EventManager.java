package com.eventplanner;
import java.util.Date;


public class EventManager {
    
    //ORGANIZER METHODS
    public void rescheduleEvent(User user, Event event, Date date, String time){
        if(!user.isOrganizer()){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.date = date;
        event.time = time;
    }

    public void cancelEvent(User user, Event event){
        if(!user.isOrganizer()){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event = null;
    }

    public void changeStatus(User user, Event event, eventStatus status){
        if(!user.isOrganizer()){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.status = status;
    }

    public String getAttendees(User user, Event event){
        if(!user.isOrganizer()){
            return "You do not have permission to perform this action.";
        }
        return event.attendees.toString();
    }

    public String getWaitlist(User user, Event event){
        if(!user.isOrganizer()){
            return "You do not have permission to perform this action.";
        }
        return event.waitlist.toString();
    }

    //ADMIN METHODS
    public void approveEvent(User user, Event event){
        if(!user.isAdmin()){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.status = eventStatus.PUBLISHED;
    }

    public void rejectEvent(User user, Event event){
        if(!user.isAdmin()){
            System.out.println("You do not have permission to perform this action.");
            return;
        }
        event.status = eventStatus.REJECTED;
    }
}
