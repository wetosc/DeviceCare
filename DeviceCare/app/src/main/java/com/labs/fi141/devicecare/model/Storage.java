package com.labs.fi141.devicecare.model;

import android.database.Cursor;

/**
 * Created by eugenius on 4/8/17.
 */

public class Storage {

    static protected Cursor validateCursor(Cursor cursor) {
        if (cursor.isBeforeFirst()) {
            cursor.moveToNext();
        }
        if (cursor.isAfterLast()) {
            return null;
        }
        return cursor;
    }
}
