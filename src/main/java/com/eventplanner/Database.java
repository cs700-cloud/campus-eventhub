package com.eventplanner;
import java.util.List;
import java.util.ArrayList;


class Database {
    private Database singleton = null;
    public static List<User> users = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();
    public static List<Venue> venues = new ArrayList<>();

    private Database(){}

    public Database getInstance(){
        if(singleton == null){
            singleton = new Database();
        }
        return singleton;
    }
}
