package com.example.nepaleats.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.nepaleats.database.dao.CartItemDao;
import com.example.nepaleats.database.models.CartItems;


@Database(entities = {CartItems.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String db_name = "nepal_eats";
    private static AppDatabase instance;

    public abstract CartItemDao dao();

    public static AppDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room
                    .databaseBuilder(context.getApplicationContext(), AppDatabase.class, db_name)
                    .build();
        }

        return instance;
    }
}

