package com.example.nepaleats.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nepaleats.models.AppPrefData;
import com.example.nepaleats.models.UserInfo;
import com.example.nepaleats.models.AppPrefData;
import com.google.gson.Gson;

public class AppPref {
    private com.google.gson.Gson gson;
    private static final String APP_SHARED_PREFS = "APP_PREF";
    private static final String PREF_DATA = "pref_data";

    private SharedPreferences sharedPreferences;

    public AppPref(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_SHARED_PREFS,
                Context.MODE_PRIVATE);
        gson = new Gson();
    }


    public boolean setPrefs(AppPrefData params) {
        return sharedPreferences.edit().putString(PREF_DATA, gson.toJson(params)).commit();
    }

    public AppPrefData getPrefs() {
        String searchParams = sharedPreferences.getString(PREF_DATA, null);
        if (searchParams != null) {
            return gson.fromJson(searchParams, AppPrefData.class);
        } else
            return null;
    }

    public void clearPrefs() {
        sharedPreferences.edit().clear().apply();
    }

}

