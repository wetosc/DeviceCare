package com.labs.fi141.devicecare.api;

import android.util.Log;

import com.labs.fi141.devicecare.model.LoginUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by eugenius on 2/25/17.
 */

public class UserService {

    UserEndpoint endpoint;

    public  UserService() {

        Retrofit retrofit = RetrofitController.getClient();
        endpoint = retrofit.create(UserEndpoint.class);

    }

    public void login(String email, String password) {

        endpoint.login(new LoginUser(email, password)).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.v("WASEA","Succes: " + response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.v("WASEA","Failure: " + t.getMessage());
            }
        });

    }

}
