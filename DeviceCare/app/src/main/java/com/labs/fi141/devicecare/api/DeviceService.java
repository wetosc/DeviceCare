package com.labs.fi141.devicecare.api;

import android.content.SharedPreferences;

import com.labs.fi141.devicecare.DeviceServiceDelegate;
import com.labs.fi141.devicecare.UserServiceDelegate;
import com.labs.fi141.devicecare.apiModel.ApiError;
import com.labs.fi141.devicecare.apiModel.SessionToken;
import com.labs.fi141.devicecare.db.DBHelper;
import com.labs.fi141.devicecare.model.Device;
import com.labs.fi141.devicecare.model.DeviceStorage;
import com.labs.fi141.devicecare.model.LoginUser;
import com.labs.fi141.devicecare.model.RegisterUser;
import com.labs.fi141.devicecare.model.UserStorage;

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

    public void getAll() {
        String token = UserStorage.getToken();
        endpoint.getAll(token).enqueue(new Callback<List<Device>>() {

            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                if (response.body().size() > 0) {
                    Device first = response.body().get(0);
                    if (first.getErrorMessage() != null) {
                        delegate.onError(first);
                        return;
                    }
                }
                delegate.onGetAllSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                delegate.onError(new ApiError(t.getMessage()));
            }
        });

    }

    public void createNew(Device device) {
        String token = UserStorage.getToken();
        endpoint.createNew(token, device).enqueue(new Callback<Device>() {

            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                Device newDevice = response.body();
                DeviceStorage.writeDevice(newDevice);
                delegate.onInsertSucces(newDevice);
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                delegate.onError(new ApiError(t.getMessage()));
            }
        });
    }

    public void update(Device device) {
        String token = UserStorage.getToken();
        endpoint.update(token, device).enqueue(new Callback<Device>() {

            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                Device newDevice = response.body();
                DeviceStorage.writeDevice(newDevice);
                delegate.onInsertSucces(newDevice);
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                delegate.onError(new ApiError(t.getMessage()));
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
