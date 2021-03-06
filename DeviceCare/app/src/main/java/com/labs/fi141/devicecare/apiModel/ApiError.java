package com.labs.fi141.devicecare.apiModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 3/4/17.
 */

public class ApiError {

    @SerializedName("errorCode")
    private Integer errorCode;

    @SerializedName("errorMessage")
    private String errorMessage = "";


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ApiError() {
        this.errorMessage = null;
        this.errorCode = null;
    }

    public ApiError(String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = -1;
    }
}
