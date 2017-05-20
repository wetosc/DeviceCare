package com.labs.fi141.devicecare;

import com.labs.fi141.devicecare.apiModel.SessionToken;
import com.labs.fi141.devicecare.model.Device;

import java.util.List;

/**
 * Created by eugenius on 3/4/17.
 */

public interface DeviceServiceDelegate extends ServiceDelegate {

    void onGetAllSuccess(List<Device> devices);

    void onInsertSucces(Device newDevice);
}
