package com.example.nepaleats.app;

import android.app.Application;

import com.example.nepaleats.database.AppDatabase;
import com.example.nepaleats.models.AppPrefData;
import com.example.nepaleats.models.UserInfo;
import com.example.nepaleats.pref.AppPref;
import com.example.nepaleats.pref.Prefs;

public class NepalEats extends Application {
    public static Prefs prefs;
    public static AppPref appPref;
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        initPref();
        initDB();

    }

    private void initPref() {
        prefs = new Prefs(getApplicationContext());
        if (prefs.getPrefs() == null) {
            prefs.setPrefs(new UserInfo());
        }

        appPref = new AppPref(getApplicationContext());
        if (appPref.getPrefs() == null){
            appPref.setPrefs(new AppPrefData());
        }
    }

    private void initDB() {
        db = AppDatabase.getInstance(getApplicationContext());
    }
}
