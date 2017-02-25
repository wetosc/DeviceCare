package com.labs.fi141.devicecare.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 2/25/17.
 */

public class User {

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @SerializedName("firstName")
    String firstName;

    @SerializedName("lastName")
    String lastName;

    @SerializedName("email")
    String email;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
