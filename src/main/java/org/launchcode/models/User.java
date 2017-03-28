package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kevin on 3/23/2017.
 */
public class User {

    @NotNull
    @Size(min=5, max=15)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min=6, message="Password must be at least 6 characters long!!")
    private String password;

    // constructor
    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // default constructor
    public User() {}

    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
