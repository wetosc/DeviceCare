package com.labs.fi141.devicecare.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import com.labs.fi141.devicecare.db.DBHelper;
import com.labs.fi141.devicecare.db.Table;

/**
 * Created by eugenius on 3/25/17.
 */

public class UserStorage {
    private static String tableName = "user";
    private static Table table = DBHelper.getInstance().getTable("user");

    public static User getFirst() {
        return userFrom(DBHelper.getInstance().
                getReadableDatabase().
                rawQuery(table.getSELECT(), null));
    }

    public static String getToken() {
        return tokenFrom(DBHelper.getInstance().
                getReadableDatabase().
                rawQuery(table.getSELECT(), null));
    }

    @Nullable
    static User userFrom(Cursor cursor) {
        if (cursor.isAfterLast()) {
            return null;
        }
        int id = cursor.getInt(0);
        String firstName = cursor.getString(1);
        String lastName = cursor.getString(2);
        String email = cursor.getString(3);
        User user = new User(firstName, lastName, email);
        return user;
    }

    @Nullable
    static String tokenFrom(Cursor cursor) {
        if (cursor.isAfterLast()) {
            return null;
        }
        String token = cursor.getString(4);
        return token;
    }

    static public void writeUser(User user, String token) {
        ContentValues values = new ContentValues();
        values.put("firstName", user.firstName);
        values.put("lastName", user.lastName);
        values.put("email", user.email);
        values.put("token", token);

        DBHelper.getInstance().getWritableDatabase().insert(tableName, null, values);
    }
}
