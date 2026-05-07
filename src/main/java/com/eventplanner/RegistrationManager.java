package com.eventplanner;

public class RegistrationManager {

    public void registerForEvent(User attendee, Event event) {
        if (!attendee.isAttendee()) {
            System.out.println("Only attendees can register for events.");
            return;
        }

        if (!attendee.isActive()) {
            System.out.println("Account must be active to register.");
            return;
        }

        if (event.getStatus() != eventStatus.PUBLISHED && event.getStatus() != eventStatus.ACTIVE) {
            System.out.println("Event is not open for registration.");
            return;
        }
        for(User u : event.getAttendeesList()){
            if (u.getEmail() == attendee.getEmail()) {
                System.out.println("User is already registered for this event.");
                return;
            }
        }

        if (event.getWaitlistList().contains(attendee)) {
            System.out.println("User is already on the waitlist.");
            return;
        }

        if (hasScheduleConflict(attendee, event)) {
            System.out.println("Schedule conflict detected.");
            return;
        }

        if (event.isFull()) {
            event.addToWaitlist(attendee);
            Notification.notifyUser(attendee.getId(), "Event is full. You have been added to the waitlist.");
            return;
        }

        event.addAttendee(attendee);
        attendee.addRegisteredEvent(event);
        Notification.notifyUser(attendee.getId(), "You have successfully registered for the event.");
    }

    public void cancelRegistration(User attendee, Event event) {
        boolean userRegistered = false;
        for(User u : event.attendees){
            if(u.equals(attendee)) {
                break;
            }
        }
        if(!userRegistered){
            System.out.println("User is not registered for this event.");
            return;
        }
        

        event.removeAttendee(attendee);
        attendee.removeRegisteredEvent(event);

        Notification.notifyUser(attendee.getId(), "Your registration has been canceled.");

        moveNextWaitlistedUser(event);
    }

    public void moveNextWaitlistedUser(Event event) {
        User nextUser = event.removeFirstFromWaitlist();

        if (nextUser == null) {
            return;
        }

        event.addAttendee(nextUser);
        nextUser.addRegisteredEvent(event);

        Notification.notifyUser(nextUser.getId(), "You have been moved from the waitlist to registered.");
    }

    public boolean hasScheduleConflict(User attendee, Event newEvent) {
        for (Event event : attendee.getRegisteredEvents()) {
            if (event.getDate().equals(newEvent.getDate()) &&
                event.getTime().equals(newEvent.getTime()) &&
                event.getStatus() != eventStatus.ARCHIVED &&
                event.getStatus() != eventStatus.REJECTED) {
                return true;
            }
        }

        return false;
    }

    public void addToWishlist(User attendee, Event event) {
        if (!attendee.isAttendee()) {
            System.out.println("Only attendees can add events to wishlist.");
            return;
        }

        if(attendee.getRegisteredEvents().contains(event)){
            System.out.println("This event is already on your wishlist.");
            return;
        }

        attendee.addWishlistEvent(event);
        Notification.notifyUser(attendee.getId(), "Event added to wishlist.");
    }

    public void removeFromWishlist(User attendee, Event event) {
        attendee.getWishlist().remove(event);
        Notification.notifyUser(attendee.getId(), "Event removed from wishlist.");
    }

    public void checkIn(User attendee, Event event) {
        for(User u : event.getAttendeesList()){
            if (u.getEmail() == attendee.getEmail()) {
                System.out.println("QR check-in successful for " + attendee.getName() + ".");
            }
        }
        System.out.println("Check-in failed. User is not registered for this event.");
        return;
    }

    public void viewRegistrationHistory(User attendee) {
        System.out.println("Registration history for " + attendee.getName() + ":");

        for (Event event : attendee.getRegisteredEvents()) {
            System.out.println("- " + event.getType() + " on " + event.getDate() + " at " + event.getTime());
        }
    }
}
