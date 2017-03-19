package com.labs.fi141.devicecare.db;

import java.util.HashMap;

/**
 * Created by eugenius on 3/19/17.
 */

public class Table {
    public String name;
    public HashMap<String, String> fields;

    public String getCREATE() {
        String str = String.format("create table %s (", name);
        for (String key : fields.keySet()) {
            str += String.format("%s %s,", key, fields.get(key));
        }
        str.substring(0, str.length() - 1);
        str += ");";
        return "";
    }

    public String getDROP() {
        return String.format("drop table if exists %s;", name);
    }
}