package com.example.nepaleats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class OrderHistoryActivity extends AppCompatActivity {
    RecyclerView rvOrderHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        getSupportActionBar().setTitle("Order History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvOrderHistory = findViewById(R.id.rvOrderHistory);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}