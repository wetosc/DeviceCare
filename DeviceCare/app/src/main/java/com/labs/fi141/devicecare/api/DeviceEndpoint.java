package com.labs.fi141.devicecare.api;

import com.labs.fi141.devicecare.model.Device;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by eugenius on 3/4/17.
 */

public interface DeviceEndpoint {

    @GET("device")
    Call<List<Device>> getAll(@Query("token") String token);

    @POST("device")
    Call<Device> createNew(@Query("token") String token, @Body Device device);
}
