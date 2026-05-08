package com.eventplanner;

public class AuthManager {

    //Register new user into the database
    public User registerUser(int id, String name, String email, String password, Role role) {
        if (findUserByEmail(email) != null) {
            System.out.println("A user with this email already exists.");
            return null;
        }

        User user = new User(id, name, email, password, role);
        Database.users.add(user);

        System.out.println("User registered successfully. Email verification required.");
        sendVerificationEmail(user);

        return user;
    }

    //Login only works if email/password match and the account is active
    public User login(String email, String password) {
        User user = findUserByEmail(email);

        if (user == null) {
            System.out.println("Invalid email or password.");
            return null;
        }

        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid email or password.");
            return null;
        }

        if (!user.isEmailVerified()) {
            System.out.println("Please verify your email before logging in.");
            return null;
        }

        if (user.getStatus() == Status.PENDING) {
            System.out.println("Account is pending approval.");
            return null;
        }

        if (user.getStatus() == Status.SUSPENDED) {
            System.out.println("Account is suspended.");
            return null;
        }

        System.out.println("Login successful. Welcome, " + user.getName() + "!");
        return user;
    }

    // Simulated email verification message
    public void sendVerificationEmail(User user) {
        System.out.println("Verification email sent to " + user.getEmail());
    }

    // Simulated email verification action
    public void verifyEmail(User user) {
        user.setEmailVerified(true);

        // For normal attendees, email verification can activate the account.
        // Organizers may still require admin approval depending on your rules.
        if (user.getRole().equals(Role.ATTENDEE) || user.getRole().equals(Role.ADMIN)) {
            user.setStatus(Status.ACTIVE);
        }

        System.out.println("Email verified for " + user.getEmail());
    }

    // Admin approves pending organizer or user account
    public void approveUser(User admin, User targetUser) {
        if (!admin.getRole().equals(Role.ADMIN)) {
            System.out.println("Only admins can approve users.");
            return;
        }

        if (!targetUser.isEmailVerified()) {
            System.out.println("Cannot approve user before email verification.");
            return;
        }

        targetUser.setStatus(Status.ACTIVE);
        System.out.println(targetUser.getName() + " has been approved.");
    }

    // Admin suspends user account
    public void suspendUser(User admin, User targetUser) {
        if (!admin.getRole().equals(Role.ADMIN)) {
            System.out.println("Only admins can suspend users.");
            return;
        }

        targetUser.setStatus(Status.SUSPENDED);
        System.out.println(targetUser.getName() + " has been suspended.");
    }

    // Admin reactivates suspended user
    public void reactivateUser(User admin, User targetUser) {
        if (!admin.getRole().equals(Role.ADMIN)) {
            System.out.println("Only admins can reactivate users.");
            return;
        }

        if (!targetUser.isEmailVerified()) {
            System.out.println("Cannot reactivate user before email verification.");
            return;
        }

        targetUser.setStatus(Status.ACTIVE);
        System.out.println(targetUser.getName() + " has been reactivated.");
    }

    // User profile update
    public void updateProfile(User user, String newName, String newEmail) {
        user.setName(newName);

        if (!user.getEmail().equals(newEmail)) {
            user.setEmail(newEmail);
            sendVerificationEmail(user);
            System.out.println("Email changed. Please verify the new email.");
        }

        System.out.println("Profile updated.");
    }

    // User password update
    public void updatePassword(User user, String oldPassword, String newPassword) {
        if (!user.getPassword().equals(oldPassword)) {
            System.out.println("Old password is incorrect.");
            return;
        }

        user.setPassword(newPassword);
        System.out.println("Password updated successfully.");
    }

    // Helper method
    public User findUserByEmail(String email) {
        for (User user : Database.users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }

        return null;
    }
}
