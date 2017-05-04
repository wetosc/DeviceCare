package com.labs.fi141.devicecare.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eugenius on 2/25/17.
 */

public class RetrofitController {

//    public static final String BASE_URL = "http://109.185.158.161:8080/";
    public static final String BASE_URL = "http://192.168.1.8:3000/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
