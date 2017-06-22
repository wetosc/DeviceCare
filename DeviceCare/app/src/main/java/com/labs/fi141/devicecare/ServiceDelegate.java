package com.labs.fi141.devicecare;

import com.labs.fi141.devicecare.apiModel.ApiError;

/**
 * Created by eugenius on 2/25/17.
 */

public interface ServiceDelegate {

    void onError(ApiError error);
}
