package com.labs.fi141.devicecare.api;

import com.labs.fi141.devicecare.model.Device;
import com.labs.fi141.devicecare.model.Remember;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by eugenius on 5/27/17.
 */

public interface RememberEndpoint {

    @GET("device-remember/{uuid}")
    Call<List<Remember>> get(@Path("uuid") String uuid, @Query("token") String token);

}
