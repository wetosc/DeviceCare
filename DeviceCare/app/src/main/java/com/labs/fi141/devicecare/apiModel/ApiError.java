package com.labs.fi141.devicecare.apiModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 3/4/17.
 */

public class ApiError {

    @SerializedName("errorCode")
    private Integer errorCode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
