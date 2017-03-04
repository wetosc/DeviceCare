package com.labs.fi141.devicecare.apiModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 2/25/17.
 */

public class SessionToken extends ApiError {

    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
