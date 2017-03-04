package com.labs.fi141.devicecare.ui;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.labs.fi141.devicecare.DeviceServiceDelegate;
import com.labs.fi141.devicecare.R;
import com.labs.fi141.devicecare.api.DeviceService;
import com.labs.fi141.devicecare.model.Device;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugenius on 3/4/17.
 */

public class DevicesActivity extends AppCompatActivity implements DeviceServiceDelegate {

    DeviceService service = new DeviceService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String token = this.getIntent().getExtras().getString("token");

        service.setDelegate(this);
        service.getAll(token);
    }


    // API Methods
    @Override
    public void onError(Error error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetAllSuccess(List<Device> devices) {
        Toast.makeText(this, devices.size() + "", Toast.LENGTH_SHORT).show();
    }
}
