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
    private boolean emailVerified;
    
    public User(int id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = Status.PENDING;
        this.emailVerified = false;
    }
    //Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole(){
        return this.role;
    }
    public Status getStatus() {
        return this.status;
    }

    public boolean isEmailVerified() {
        return this.emailVerified;
    }

    //Setters
       public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
        this.emailVerified = false;
        this.status = Status.PENDING;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    //Roles

    public boolean isOrganizer(){
        return this.role == Role.ORGANIZER;
    }

    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }
    public boolean isAttendee() {
        return this.role == Role.ATTENDEE;
    }

    public boolean isActive() {
        return this.status == Status.ACTIVE;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", emailVerified=" + emailVerified + '}';
    }
}
