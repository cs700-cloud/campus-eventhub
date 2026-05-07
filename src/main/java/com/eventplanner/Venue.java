package com.eventplanner;

public class Venue {
    int id;
    String name;
    int capacity;
    String[] equipment;

    public Venue(int id, String name, int capacity, String[] equipment){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.equipment = equipment;
    }

    public int getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String[] getEquipment(){
        return this.equipment;
    }
}
