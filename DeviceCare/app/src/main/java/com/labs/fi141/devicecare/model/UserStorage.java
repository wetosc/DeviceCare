package com.labs.fi141.devicecare.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;

import com.labs.fi141.devicecare.db.DBHelper;
import com.labs.fi141.devicecare.db.Table;

/**
 * Created by eugenius on 3/25/17.
 */

public class UserStorage extends Storage {

    private static String tableName = "user";
    private static Table table = DBHelper.getInstance().getTable("user");

    public static User getFirst() {
        return userFrom(DBHelper.getInstance().
                getReadableDatabase().
                rawQuery(table.getSELECT(), null));
    }

    public static String getToken() {
        String cachedToken = DBHelper.getInstance().getCache().getToken();
        if (cachedToken != null) {
            return cachedToken;
        }

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
        Cursor validatedCursor = validateCursor(cursor);
        if (validatedCursor == null) {
            return null;
        }
        String token = validatedCursor.getString(validatedCursor.getColumnIndex("token"));
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

    static public void writeToken(String token) {
        deleteAll();

        ContentValues values = new ContentValues();
        values.put("token", token);

        DBHelper.getInstance().getWritableDatabase().insert(tableName, null, values);
        DBHelper.getInstance().getCache().setToken(token);
    }

    static private void deleteAll() {
        DBHelper.getInstance().getWritableDatabase().execSQL(String.format("delete from %s", tableName));
    }

    static public void deleteToken(String token) {
        ContentValues values = new ContentValues();
        values.put("token", (String) null);
        DBHelper.getInstance().getWritableDatabase().update(table.getName(), values, "token = ?", new String[]{token});
    }
}
