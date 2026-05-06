package com.eventplanner;
import java.util.Date;

enum Status{
    DRAFT,
    PUBLISHED,
    ACTIVE,
    COMPLETED,
    ARCHIVED
}

public class Event {
    //Create/Edit/Delete Events (with venue, date, time, type, description, etc.) 
    int capacity;
    Date date;
    String venueID;
    String time;
    String type;
    String description;
    Status status;
    User[] attendees;
    User[] waitlist;

    public void constructor(String venueID, Date date, String time, String type, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = "";
        this.capacity = capacity;
        this.status = Status.PUBLISHED;

        this.attendees = new User[capacity];
    }

    public void constructor(String venueID, Date date, String time, String type, String description, int capacity){
        this.venueID = venueID;
        this.date = date;
        this.time = time;
        this.type = type;
        this.description = description;
        this.capacity = capacity;
        this.status = Status.PUBLISHED;

        this.attendees = new User[capacity];
    }

}
