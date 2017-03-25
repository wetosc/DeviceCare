package com.labs.fi141.devicecare.db;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;

import com.labs.fi141.devicecare.ui.App;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugenius on 3/19/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;
    private static final String DATABASE_NAME = "Main.db";
    private static final int DATABASE_VERSION = 1;

    public static synchronized DBHelper getInstance() {
        if (sInstance == null) {
            sInstance = new DBHelper();
        }
        return sInstance;
    }

    private DBHelper() {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "";
        for (Table table : tables.values()) {
            createQuery += table.getCREATE();
        }
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropQuery = "";
        for (Table table : tables.values()) {
            dropQuery += table.getDROP();
        }
        db.execSQL(dropQuery);
        onCreate(db);
    }

    private HashMap<String, Table> tables = configureTables();

    private HashMap<String, Table> configureTables() {
        HashMap<String, Table> result = new HashMap<String, Table>();

        Table devices = new Table();
        devices.name = "device";
        HashMap<String, String> devicesFields = new HashMap<>();
        devicesFields.put("id", "integer primary key");
        devicesFields.put("name", "text");
        devicesFields.put("type", "text");
        devicesFields.put("description", "text");
        devices.fields = devicesFields;
        result.put(devices.name, devices);

        Table users = new Table();
        users.name = "user";
        HashMap<String, String> usersFields = new HashMap<>();
        usersFields.put("id", "integer primary key");
        usersFields.put("firstName", "text");
        usersFields.put("lastName", "text");
        usersFields.put("email", "text");
        usersFields.put("token", "text");
        users.fields = usersFields;
        result.put(users.name, users);

        return result;
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }
}
