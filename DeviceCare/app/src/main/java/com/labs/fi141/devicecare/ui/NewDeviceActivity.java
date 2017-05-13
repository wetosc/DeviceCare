package com.labs.fi141.devicecare.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.labs.fi141.devicecare.DeviceServiceDelegate;
import com.labs.fi141.devicecare.R;
import com.labs.fi141.devicecare.api.DeviceService;
import com.labs.fi141.devicecare.apiModel.ApiError;
import com.labs.fi141.devicecare.model.Device;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eugenius on 3/18/17.
 */

public class NewDeviceActivity extends AppCompatActivity implements DeviceServiceDelegate {

    DeviceService service = new DeviceService();
    String deviceType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_device);

        service.setDelegate(this);
    }

    public void selectType(View v) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_text_item, R.id.textView, Arrays.asList("mobile", "laptop"));
        DialogPlus dialog = DialogPlus.newDialog(this)
                .setAdapter(adapter)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                        deviceType = (String) item;
                        Button button = (Button) findViewById(R.id.type);
                        button.setText(deviceType.toUpperCase());
                        dialog.dismiss();
                    }
                })
                .setExpanded(true)
                .create();
        dialog.show();
    }

    public void submit(View v) {
        Device device = new Device();
        device.setType(deviceType);

        TextView nameTextView = (TextView) findViewById(R.id.name);
        device.setName(nameTextView.getText().toString());

        TextView descriptionTextView = (TextView) findViewById(R.id.description);
        device.setDescription(descriptionTextView.getText().toString());

        service.createNew(device);
    }

    public void cancel(View v) {
        finish();
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }


    @Override
    public void onError(ApiError error) {
        Toast.makeText(this, error.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetAllSuccess(List<Device> devices) {
    }

    @Override
    public void onInsertSucces(Device newDevice) {
        finish();
    }
}
