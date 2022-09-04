package com.example.nepaleats.managers;

import android.util.Log;

import com.example.nepaleats.app.NepalEats;
import com.example.nepaleats.models.AppPrefData;
import com.example.nepaleats.pref.AppPref;

public class PrefManager {

        public static void setRestaurantID(int table_id){
            AppPref appPref = NepalEats.appPref;
            if(appPref != null){
                AppPrefData appPrefData = appPref.getPrefs();
                appPrefData.setResturant_id(table_id);
                appPref.setPrefs(appPrefData);
                Log.d("sugam","Table ID Saved in Prefs ==> "+table_id);
            }
        }

        public static int getRestaurantID(){
            AppPref appPref = NepalEats.appPref;
            if(appPref != null){
                AppPrefData appPrefData = appPref.getPrefs();
                return appPrefData.getResturant_id();
            }
            return -1;
        }


}
