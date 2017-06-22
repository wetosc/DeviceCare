package com.labs.fi141.devicecare.apiModel;

/**
 * Created by eugenius on 4/8/17.
 */

public enum ApiErrorEnum {

    Internal(-1),
    InvalidToken(3);


    private int code;

    ApiErrorEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
