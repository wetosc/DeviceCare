package com.labs.fi141.devicecare.api;

import com.labs.fi141.devicecare.model.LoginUser;
import com.labs.fi141.devicecare.model.RegisterUser;
import com.labs.fi141.devicecare.apiModel.SessionToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by eugenius on 2/25/17.
 */

public interface UserEndpoint {

    @POST("user/authentication")
    Call<SessionToken> login(@Body LoginUser user);

    @POST("user/registration")
    Call<SessionToken> register(@Body RegisterUser user);

}
