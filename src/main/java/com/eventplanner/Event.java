package com.eventplanner;
import java.time.LocalDate;
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
    int organizerID;
    int venueID;
    String name;
    String time;
    String type;
    String description;
    eventStatus status;
    User[] attendees;
    List<User> waitlist;

    public Event(int venueID, LocalDate date, String name, String time, String type, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.name = name;
        this.time = time;
        this.type = type;
        this.description = "";
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;

        this.attendees = new User[capacity];
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

        this.attendees = new User[capacity];
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
        User removeduser = this.waitlist.get(0);
        this.waitlist.remove(0);
        return removeduser;
    }

    public String getName(){
        return this.name;
    }

    public eventStatus getStatus(){
        return this.status;
    }

    public User[] getAttendeesList(){
        return this.attendees;
    }

    public List<User> getWaitlistList(){
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
}
