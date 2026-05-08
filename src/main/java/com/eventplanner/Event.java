package com.eventplanner;
import java.time.LocalDate;
import java.util.Queue;
import java.util.List;

enum eventStatus{
    DRAFT,
    PUBLISHED,
    ACTIVE,
    COMPLETED,
    ARCHIVED,
    REJECTED
}

public class Event {
    //Create/Edit/Delete Events (with venue, date, time, type, description, etc.) 
    int capacity;
    LocalDate date;
    int eventID;
    int organizerID;
    int venueID;
    String name;
    String time;
    String type;
    String description;
    eventStatus status;
    List<User> attendees;
    Queue<User> waitlist;

    public Event(int venueID, LocalDate date, String name, String time, String type, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.name = name;
        this.time = time;
        this.type = type;
        this.description = "";
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;
    }

    public Event(int venueID, LocalDate date, String name, String time, String type, String description, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.name = name;
        this.time = time;
        this.type = type;
        this.description = description;
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;
    }

    public boolean isFull(){
        for(User u : this.attendees){
            if(u == null){
                return false;
            }
        }
        return true;
    }

    public void addAttendee(User user){
        for(User u : this.attendees){
            if(u == null){
                u = user;
                return;
            }
        }
    }

    public void removeAttendee(User user){
        for(User u : this.attendees){
            if(u.getEmail() == user.getEmail()){
                u = null;
                return;
            }
        }
    }

    public void addToWaitlist(User user){
        this.waitlist.add(user);
    }

    public User removeFirstFromWaitlist(){
        User removeduser = this.waitlist.remove();
        return removeduser;
    }

    public int getID(){
        return this.eventID;
    }

    public String getName(){
        return this.name;
    }

    public eventStatus getStatus(){
        return this.status;
    }

    public List<User> getAttendeesList(){
        return this.attendees;
    }

    public Queue<User> getWaitlistList(){
        return this.waitlist;
    }

    public LocalDate getDate(){
        return this.date;
    }
    
    public String getTime(){
        return this.time;
    }

    public int getVenueID(){
        return this.venueID;
    }

    public String getType(){
        return this.type;
    }

    public void setStatus(eventStatus e){
        this.status = e;
    }
}
