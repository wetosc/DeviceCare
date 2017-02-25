package com.labs.fi141.devicecare.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 2/25/17.
 */

public class RegisterUser extends User {

    @SerializedName("password")
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
