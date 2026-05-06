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
    private String password;
    private Role role;
    private Status status;

    public User(int id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = Status.PENDING;
    }

    public Role getRole(){
        return this.role;
    }

    public boolean isOrganizer(){
        return this.role == Role.ORGANIZER;
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }


}
