package com.labs.fi141.devicecare.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 2/25/17.
 */

public class LoginUser {

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;


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
