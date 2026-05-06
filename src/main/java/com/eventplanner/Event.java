package com.eventplanner;
import java.util.Date;

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
    Date date;
    int organizerID;
    int venueID;
    String time;
    String type;
    String description;
    eventStatus status;
    User[] attendees;
    User[] waitlist;

    public Event(int venueID, Date date, String time, String type, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = "";
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;

        this.attendees = new User[capacity];
    }

    public Event(int venueID, Date date, String time, String type, String description, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = description;
        this.capacity = capacity;
        this.status = eventStatus.PUBLISHED;

        this.attendees = new User[capacity];
    }

    public Date getDate(){
        return this.date;
    }
    
    public String getTime(){
        return this.time;
    }
}
