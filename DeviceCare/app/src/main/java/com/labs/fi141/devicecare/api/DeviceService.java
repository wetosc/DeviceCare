package com.labs.fi141.devicecare.api;

import com.labs.fi141.devicecare.DeviceServiceDelegate;
import com.labs.fi141.devicecare.UserServiceDelegate;
import com.labs.fi141.devicecare.apiModel.SessionToken;
import com.labs.fi141.devicecare.model.Device;
import com.labs.fi141.devicecare.model.LoginUser;
import com.labs.fi141.devicecare.model.RegisterUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Query;

/**
 * Created by eugenius on 3/4/17.
 */

public class DeviceService {

    DeviceServiceDelegate delegate;

    DeviceEndpoint endpoint;

    public DeviceService() {

        Retrofit retrofit = RetrofitController.getClient();
        endpoint = retrofit.create(DeviceEndpoint.class);
    }

    public void getAll(String token) {

        endpoint.getAll(token).enqueue(new Callback<List<Device>>() {

            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                delegate.onGetAllSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                delegate.onError(new Error(t));
            }
        });

    }

    public DeviceServiceDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(DeviceServiceDelegate delegate) {
        this.delegate = delegate;
    }
}
