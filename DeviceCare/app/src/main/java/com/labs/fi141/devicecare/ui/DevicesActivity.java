package com.labs.fi141.devicecare.ui;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.labs.fi141.devicecare.DeviceServiceDelegate;
import com.labs.fi141.devicecare.R;
import com.labs.fi141.devicecare.api.DeviceService;
import com.labs.fi141.devicecare.apiModel.ApiError;
import com.labs.fi141.devicecare.apiModel.ApiErrorEnum;
import com.labs.fi141.devicecare.db.DBHelper;
import com.labs.fi141.devicecare.model.Device;
import com.labs.fi141.devicecare.model.DeviceStorage;
import com.labs.fi141.devicecare.model.UserStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugenius on 3/4/17.
 */

public class DevicesActivity extends AppCompatActivity implements DeviceServiceDelegate {

    private RecyclerView recyclerView;
    private DevicesRecyclerAdapter adapter;
    private List<Device> devices;

    DeviceService service = new DeviceService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_list);

        service.setDelegate(this);
        service.getAll();

        configureRecycleView();

        configureFAB();

        loadFromDB();
    }

    void configureRecycleView() {
        adapter = new DevicesRecyclerAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Device device = devices.get(position);
                Intent intent = new Intent(DevicesActivity.this, DetailDeviceActivity.class);
                intent.putExtra("device", device.getUuid());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    void configureFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DevicesActivity.this, NewDeviceActivity.class));
            }
        });
    }

    void loadFromDB() {
        List<Device> devices = DeviceStorage.getAll();
        updateTable(devices);
    }

    void updateTable(List<Device> devices) {
        this.devices = devices;
        adapter.setDevices(new ArrayList<>(devices));
        adapter.notifyDataSetChanged();
    }


    // API Methods
    public void onError(ApiError error) {
        if (error.getErrorCode() == ApiErrorEnum.InvalidToken.getCode()) {
            UserStorage.deleteToken(UserStorage.getToken());
            startActivity(new Intent(DevicesActivity.this, LoginActivity.class));
        }

        Toast.makeText(this, error.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    public void onGetAllSuccess(List<Device> devices) {
        DeviceStorage.writeDevices(devices);
        updateTable(devices);
    }

    @Override
    public void onInsertSucces(Device newDevice) {
        loadFromDB();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadFromDB();
    }
}
