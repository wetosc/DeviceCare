package com.labs.fi141.devicecare.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.labs.fi141.devicecare.R;
import com.labs.fi141.devicecare.model.Device;
import com.labs.fi141.devicecare.model.DeviceStorage;

/**
 * Created by eugenius on 5/26/17.
 */

public class DetailDeviceActivity extends AppCompatActivity {

    Device device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);
        configureFAB();

        String deviceUUID = getIntent().getStringExtra("device");
        configure(DeviceStorage.getOne(deviceUUID));
    }

    void configureFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailDeviceActivity.this, UpdateDeviceActivity.class));
            }
        });
    }

    void configure(Device device) {
        this.device = device;

        String text = "";
        text += String.format("Name:  %s\n", device.getName());
        text += String.format("Type:  %s\n", device.getType());
        text += String.format("Description:  %s", device.getDescription());

        TextView textView = (TextView) findViewById(R.id.info);
        textView.setText(text);

        ImageView imageView = (ImageView) findViewById(R.id.icon);
        int imageID = 0;
        switch (device.getType()) {
            case "mobile":
            case "phone":
                imageID = R.drawable.ic_phone;
                break;
            case "laptop":
            case "notebook":
                imageID = R.drawable.ic_laptop;
                break;
        }
        if (imageID != 0) {
            imageView.setImageResource(imageID);
        }
    }
}
