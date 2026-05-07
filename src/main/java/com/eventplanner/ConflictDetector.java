package com.eventplanner;

import java.time.LocalDate;
import java.util.List;

class ConflictDetector {

    public static boolean isConflict(List<Event> userEvents, Event newEvent) {
        return userEvents.stream().anyMatch(e ->
            e.getDate().equals(newEvent.getDate()) &&
            e.getTime().equals(newEvent.getTime())
        );
    }

    public static boolean isVenueAvailable(List<Event> events, int venueId,
                                           LocalDate date, String time) {
        return events.stream().noneMatch(e ->
            e.getVenueID() == venueId &&
            e.getDate().equals(date) &&
            e.getTime().equals(time)
        );
    }
}
