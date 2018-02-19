package com.labs.fi141.devicecare.model;

import com.google.gson.annotations.SerializedName;
import com.labs.fi141.devicecare.apiModel.ApiError;
import com.labs.fi141.devicecare.apiModel.InstantDate;

/**
 * Created by eugenius on 5/27/17.
 */

public class Remember extends ApiError {

    @SerializedName("id")
    private int id;

    @SerializedName("deviceRememberType")
    private String deviceRememberType;

    @SerializedName("description")
    private String description;

    @SerializedName("date")
    private InstantDate date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceRememberType() {
        return deviceRememberType;
    }

    public void setDeviceRememberType(String deviceRememberType) {
        this.deviceRememberType = deviceRememberType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstantDate getDate() {
        return date;
    }

    public void setDate(InstantDate date) {
        this.date = date;
    }
}
