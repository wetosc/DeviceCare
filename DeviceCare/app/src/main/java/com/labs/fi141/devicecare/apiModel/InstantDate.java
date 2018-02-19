package com.labs.fi141.devicecare.apiModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eugenius on 5/27/17.
 */

public class InstantDate {

    @SerializedName("epochSecond")
    private int epochSecond;

    @SerializedName("nano")
    private int nano;

    public int getEpochSecond() {
        return epochSecond;
    }

    public void setEpochSecond(int epochSecond) {
        this.epochSecond = epochSecond;
    }

    public int getNano() {
        return nano;
    }

    public void setNano(int nano) {
        this.nano = nano;
    }
}
