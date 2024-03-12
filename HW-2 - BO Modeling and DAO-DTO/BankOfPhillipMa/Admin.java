package BankOfPhillipMa;

import java.util.*;

public class Admin extends User {

    private String adminLevel; // e.g., "Branch Admin", "System Admin"
    private List<String> permissions; // Specific permissions granted

    // Constructor
    public Admin(String name, Date birthday, String email, String username, int pin, String password,
            String adminLevel, List<String> permissions) {
        super(name, birthday, email, username, pin, password);
        this.adminLevel = adminLevel;
        this.permissions = permissions;
    }

    // Getters and Setters
    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    // Admin-specific methods
    public void addUser(User newUser) {
        // Logic to add a new user to the system
    }

    public void removeUser(String username) {
        // Logic to remove a user
    }

    public void updateUser(User updatedUser) {
        // Logic to update user details
    }
}
