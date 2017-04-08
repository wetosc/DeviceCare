package com.labs.fi141.devicecare.model;

import com.google.gson.annotations.SerializedName;
import com.labs.fi141.devicecare.apiModel.ApiError;

/**
 * Created by eugenius on 3/4/17.
 */

public class Device extends ApiError {

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("description")
    private String description;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
