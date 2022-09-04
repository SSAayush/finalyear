package com.example.nepaleats.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.nepaleats.models.UserInfo;
import com.google.gson.Gson;

public class Prefs {
    private com.google.gson.Gson gson;
    private static final String APP_SHARED_PREFS = "USER_PREF";
    private static final String PREF_DATA = "pref_data";

    private SharedPreferences sharedPreferences;

    public Prefs(Context context) {
        this.sharedPreferences = context.getSharedPreferences(APP_SHARED_PREFS, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public boolean setPrefs(UserInfo params) {
        Log.d("aayush","Inside set prefs " + params.getEmail());
        return sharedPreferences.edit().putString(PREF_DATA, gson.toJson(params)).commit();
    }

    public UserInfo getPrefs() {
        String searchParams = sharedPreferences.getString(PREF_DATA, null);
        if (searchParams != null) {
            return gson.fromJson(searchParams, UserInfo.class);
        } else
            return null;
    }

    public void clearPrefs() {
        sharedPreferences.edit().clear().apply();
    }



}
