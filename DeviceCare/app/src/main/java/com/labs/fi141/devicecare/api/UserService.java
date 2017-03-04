package com.labs.fi141.devicecare.api;

import com.labs.fi141.devicecare.R;
import com.labs.fi141.devicecare.UserServiceDelegate;
import com.labs.fi141.devicecare.model.LoginUser;
import com.labs.fi141.devicecare.model.RegisterUser;
import com.labs.fi141.devicecare.apiModel.SessionToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by eugenius on 2/25/17.
 */

public class UserService {

    UserServiceDelegate delegate;

    UserEndpoint endpoint;

    public  UserService() {

        Retrofit retrofit = RetrofitController.getClient();
        endpoint = retrofit.create(UserEndpoint.class);

    }

    public void login(String email, String password) {

        endpoint.login(new LoginUser(email, password)).enqueue(new Callback<SessionToken>() {
            @Override
            public void onResponse(Call<SessionToken> call, Response<SessionToken> response) {
                if ( response.body().getErrorCode() != null ) {
                    delegate.onError(new Error(response.body().getErrorMessage()));
                } else {
                    delegate.onLoginSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<SessionToken> call, Throwable t) {
                delegate.onError(new Error(t));
            }
        });

    }

    public void register(String firstName, String lastName, String email, String password) {

        endpoint.register( new RegisterUser(firstName, lastName, email, password)).enqueue(new Callback<SessionToken>() {
            @Override
            public void onResponse(Call<SessionToken> call, Response<SessionToken> response) {
                if ( response.body().getErrorCode() != null ) {
                    delegate.onError(new Error(response.body().getErrorMessage()));
                } else {
                    delegate.onRegisterSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<SessionToken> call, Throwable t) {
                delegate.onError(new Error(t));
            }
        });
    }

    public UserServiceDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(UserServiceDelegate delegate) {
        this.delegate = delegate;
    }


}
