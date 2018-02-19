package com.labs.fi141.devicecare.api;

import com.labs.fi141.devicecare.RememberServiceDelegate;
import com.labs.fi141.devicecare.apiModel.ApiError;
import com.labs.fi141.devicecare.model.Remember;
import com.labs.fi141.devicecare.model.UserStorage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by eugenius on 5/27/17.
 */

public class RememberService {

    private RememberEndpoint endpoint;
    private RememberServiceDelegate delegate;

    public RememberService() {

        Retrofit retrofit = RetrofitController.getClient();
        endpoint = retrofit.create(RememberEndpoint.class);
    }

    public void getForDevice(String deviceUUID) {
        String token = UserStorage.getToken();
        endpoint.get(deviceUUID, token).enqueue(new Callback<List<Remember>>() {
            @Override
            public void onResponse(Call<List<Remember>> call, Response<List<Remember>> response) {
                if (response.body().size() > 0) {
                    Remember first = response.body().get(0);
                    if (first.getErrorMessage() != null) {
                        delegate.onError(first);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Remember>> call, Throwable t) {
                delegate.onError(new ApiError(t.getMessage()));
            }
        });


    }


}
