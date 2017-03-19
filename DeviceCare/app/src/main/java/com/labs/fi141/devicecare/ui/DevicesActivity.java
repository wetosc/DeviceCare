package com.labs.fi141.devicecare.ui;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    private RecyclerView recyclerView;
    private DevicesRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    DeviceService service = new DeviceService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_list);
        String token = this.getIntent().getExtras().getString("token");

        service.setDelegate(this);
        service.getAll();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DevicesRecyclerAdapter();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DevicesActivity.this, NewDeviceActivity.class);
                startActivity(intent);
            }
        });
    }


    // API Methods
    public void onError(Error error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void onGetAllSuccess(List<Device> devices) {
        Toast.makeText(this, devices.size() + "", Toast.LENGTH_SHORT).show();
        ArrayList<Device> devicesArray = new ArrayList<>(devices);
        adapter.setDevices(devicesArray);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onInsertSucces(Device newDevice) {
    }

}
