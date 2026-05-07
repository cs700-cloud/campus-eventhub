package com.eventplanner;
import java.time.LocalDate;

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
    User[] waitlist;

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

    public String getName(){
        return this.name;
    }

    public LocalDate getDate(){
        return this.date;
    }
    
    public String getTime(){
        return this.time;
    }

    public int getVenueId(){
        return this.venueID;
    }
}
