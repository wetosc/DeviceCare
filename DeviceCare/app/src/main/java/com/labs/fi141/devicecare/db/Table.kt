package com.labs.fi141.devicecare.db

import java.util.HashMap

/**
 * Created by eugenius on 3/19/17.
 */

class Table {
    var name: String? = null
    var fields: HashMap<String, String>? = null

    val CREATE: String
        get() {
            var str = "create table ${name} ("
            for (key in fields!!.keys) {
                str += "${key} ${fields!![key]},"
            }
            str = str.subSequence(0, str.length - 1).toString()
            str += ");"
            return str
        }

    val DROP: String
        get() = "drop table if exists ${name};"

    val SELECT: String
        get() = "select * from ${name}"

    fun getSELECT(paramName: String): String {
        return "select * from ${name} where ${paramName} == ?"
    }
}
