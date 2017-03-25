package com.labs.fi141.devicecare.ui;

import android.app.Application;
import android.content.Context;

/**
 * Created by eugenius on 3/25/17.
 */

public class App extends Application {

    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}
