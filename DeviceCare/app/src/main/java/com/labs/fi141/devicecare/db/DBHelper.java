package com.labs.fi141.devicecare.db;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by eugenius on 3/19/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper sInstance;
    private static final String DATABASE_NAME = "Main.db";
    private static final int DATABASE_VERSION = 1;

    public static synchronized DBHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "";
        for (Table table: tables) {
            createQuery += table.getCREATE();
        }
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropQuery = "";
        for (Table table: tables) {
            dropQuery += table.getDROP();
        }
        db.execSQL(dropQuery);
        onCreate(db);
    }

    private ArrayList<Table> tables = configureTables();

    private ArrayList<Table> configureTables() {
        ArrayList<Table> result = new ArrayList<>();

        return result;
    }

}
