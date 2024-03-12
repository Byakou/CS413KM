package BankOfPhillipMa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    // Private attributes
    private String name;
    private Date birthday;
    private String email;
    private String username;
    private int pin;
    private String password; // Important: Never store passwords in plain text!

    // Constructor
    public User(String name, Date birthday, String email, String username, int pin, String password) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.username = username;
        this.pin = pin;
        this.password = password;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User object with name '" + name + "' and email '" + email + "'";
    }

}
