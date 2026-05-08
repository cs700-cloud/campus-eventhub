package com.eventplanner;

import java.time.LocalDate;

public class VenueManager {

    public static void addVenue(User admin, Venue venue) {
        if (!admin.getRole().equals(Role.ADMIN)) {
            System.out.println("Only admins can add venues.");
            return;
        }

        if (findVenueById(venue.getID()) != null) {
            System.out.println("Venue with this ID already exists.");
            return;
        }

        Database.venues.add(venue);
        System.out.println("Venue added: " + venue.getName());
    }

    public static void removeVenue(User admin, int venueID) {
        if (!admin.getRole().equals(Role.ADMIN)) {
            System.out.println("Only admins can remove venues.");
            return;
        }

        Venue venue = findVenueById(venueID);

        if (venue == null) {
            System.out.println("Venue not found.");
            return;
        }

        Database.venues.remove(venue);
        System.out.println("Venue removed: " + venue.getName());
    }

    public static Venue findVenueById(int venueID) {
        for (Venue venue : Database.venues) {
            if (venue.getID() == venueID) {
                return venue;
            }
        }

        return null;
    }

    public static void listVenues() {
        if (Database.venues.isEmpty()) {
            System.out.println("No venues available.");
            return;
        }

        for (Venue venue : Database.venues) {
            System.out.println(venue);
        }
    }

    public static boolean isVenueAvailable(int venueID, LocalDate date, String time) {
        for (Event event : Database.events) {
            if (event.getVenueID() == venueID &&
                event.getDate().equals(date) &&
                event.getTime().equals(time) &&
                event.getStatus() != eventStatus.ARCHIVED &&
                event.getStatus() != eventStatus.REJECTED) {
                return false;
            }
        }

        return true;
    }

    public static boolean canFitEvent(int venueID, int eventCapacity) {
        Venue venue = findVenueById(venueID);

        if (venue == null) {
            System.out.println("Venue not found.");
            return false;
        }

        return venue.getCapacity() >= eventCapacity;
    }

    public static void showVenueEquipment(int venueID) {
        Venue venue = findVenueById(venueID);

        if (venue == null) {
            System.out.println("Venue not found.");
            return;
        }

        System.out.println("Equipment for " + venue.getName() + ":");

        for (String item : venue.getEquipment()) {
            System.out.println("- " + item);
        }
    }
}
