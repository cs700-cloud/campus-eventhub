package com.eventplanner;

enum Role {
    ADMIN,
    ORGANIZER,
    ATTENDEE
}

enum Status {
    ACTIVE,
    SUSPENDED,
    PENDING
}

class User {
    private int id;
    private String name;
    private String email;
    private Role role;
    private Status status;

    public User(int id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.status = Status.PENDING;
    }

    public boolean isOrganizer(User inputUser){
        return this.role == Role.ORGANIZER;
    }

    public boolean isAdmin(User inputUser){
        return this.role == Role.ADMIN;
    }
}
