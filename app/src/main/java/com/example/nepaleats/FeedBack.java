package com.example.nepaleats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity {
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        getSupportActionBar().setTitle("Feed Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intiVars();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedBack.this, "Thanks for your feedBack",Toast.LENGTH_SHORT).show();
                
            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void intiVars(){
        btnSubmit= (Button)findViewById(R.id.btnSubmit);
    }
}