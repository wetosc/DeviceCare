package com.labs.fi141.devicecare.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import com.labs.fi141.devicecare.db.DBHelper;
import com.labs.fi141.devicecare.db.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugenius on 3/25/17.
 */

public class DeviceStorage extends Storage {

    private static Table table = DBHelper.getInstance().getTable("device");

    public static List<Device> getAll() {
        ArrayList<Device> list = new ArrayList<>();
        Cursor cursor = DBHelper.getInstance().getReadableDatabase().rawQuery(table.getSELECT(), null);
        while (cursor.moveToNext()) {
            list.add(deviceFrom(cursor));
        }
        return list;
    }

    public static Device getOne(String id) {
        Cursor cursor = DBHelper.getInstance().getReadableDatabase().rawQuery(table.getSELECT(), null);
        return deviceFrom(validateCursor(cursor));
    }



    @Nullable
    private static Device deviceFrom(Cursor cursor) {
        if (cursor == null) {
            return null;
        }

        Device device = new Device();
        device.setUuid(cursor.getString(cursor.getColumnIndex("uuid")));
        device.setName(cursor.getString(cursor.getColumnIndex("name")));
        device.setType(cursor.getString(cursor.getColumnIndex("type")));
        device.setDescription(cursor.getString(cursor.getColumnIndex("description")));

        return device;
    }

    public static void writeDevice(Device device) {
        ContentValues values = new ContentValues();
        values.put("uuid", device.getUuid());
        values.put("name", device.getName());
        values.put("type", device.getType());
        values.put("description", device.getDescription());

        Device dbDevice = getOne(device.getUuid());
        if (dbDevice != null) {
            DBHelper.getInstance().getWritableDatabase().update(table.getName(), values,
                    "uuid = ?", new String[]{device.getUuid()});
        } else {
            DBHelper.getInstance().getWritableDatabase().insert(table.getName(), null, values);
        }
    }

    public static void writeDevices(List<Device> devices) {
        for (Device device: devices) {
            writeDevice(device);
        }
    }

}
