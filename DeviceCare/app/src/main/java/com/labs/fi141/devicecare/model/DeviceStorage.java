package com.labs.fi141.devicecare.model;

import android.database.Cursor;

import com.labs.fi141.devicecare.db.DBHelper;
import com.labs.fi141.devicecare.db.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugenius on 3/25/17.
 */

public class DeviceStorage {

    private static Table table = DBHelper.getInstance().getTable("device");

    public static List<Device> getAll() {
        ArrayList<Device> list = new ArrayList<>();
        Cursor cursor = DBHelper.getInstance().getReadableDatabase().rawQuery(table.getSELECT(), null);
        while (cursor.moveToNext()) {
            list.add(deviceFrom(cursor));
        }
        return list;
    }

    private static Device deviceFrom(Cursor cursor) {
        Device device = new Device();

        int id = cursor.getInt(0);
        device.setName(cursor.getString(1));
        device.setType(cursor.getString(2));
        device.setDescription(cursor.getString(3));

        return device;
    }
}
