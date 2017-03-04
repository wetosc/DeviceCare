package com.labs.fi141.devicecare.model;

import com.google.gson.annotations.SerializedName;
import com.labs.fi141.devicecare.model.User;

/**
 * Created by eugenius on 2/25/17.
 */

public class RegisterUser extends User {

    public RegisterUser(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email);
        this.password = password;
    }

    @SerializedName("password")
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
