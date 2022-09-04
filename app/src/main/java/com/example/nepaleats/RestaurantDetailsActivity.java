package com.example.nepaleats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.managers.CartManager;
import com.example.nepaleats.models.Category;
import com.example.nepaleats.models.DataModel;
import com.example.nepaleats.adapters.ItemAdapter;
import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.models.Food;
import com.example.nepaleats.models.ProductItem;
import com.example.nepaleats.response.CategoryResponse;
import com.google.android.material.textview.MaterialTextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantDetailsActivity extends AppCompatActivity {
    private Context context;
    private MaterialTextView tvName, tvLocation, tvDeliveryTime, tvMinOrder, tvOpeningTime, tvClosingTime;
    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private String name, address, delivery_time, min_order, openingTime, closingTime;
    private int id;
    private ArrayList<Category> categoryArrayList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        getSupportActionBar().setTitle("Restaurant");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initVars();
        showRestaurantDetails();
        apiCategoryCall();

    }
   

    private void apiCategoryCall() {
        Log.d("aayush","apiCategoryCall=======>");
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoryResponse> call = apiInterface.getAllCategory(
            id
        );
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(@NotNull Call<CategoryResponse> call, @NotNull Response<CategoryResponse> response) {
                CategoryResponse rs = response.body();
                Log.d("aayush","Size of response=========>"+String.valueOf(rs.getData().size()));
                if (rs.isSuccess()){
                    Log.d("aayush","Size of response=========>"+String.valueOf(rs.getData().size()));
                    categoryArrayList = rs.getData();
                    adapter = new ItemAdapter(context,categoryArrayList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(@NotNull Call<CategoryResponse> call, @NotNull Throwable t) {
                Log.d("aayush",t.getMessage());
            }
        });
    }

    private void showRestaurantDetails() {
        tvName.setText(name);
        tvLocation.setText(address);
        tvDeliveryTime.setText(delivery_time);
        tvMinOrder.setText(String.format("Min Order %s",min_order));
        tvOpeningTime.setText(String.format("Opening Time %s",openingTime));
        tvClosingTime.setText(String.format("Closing Time %s",closingTime));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initVars() {
        context = this;
        tvName= findViewById(R.id.nameRes);
        tvLocation= findViewById(R.id.locationRes);
        tvDeliveryTime= findViewById(R.id.deliveryTimeRes);
        tvMinOrder=findViewById(R.id.min_oderRes);
        tvOpeningTime=findViewById(R.id.tvOpeningTime);
        tvClosingTime=findViewById(R.id.closingTime);

        Intent intent = getIntent();
        id=intent.getIntExtra("resId",0);
        name = intent.getStringExtra("resName");
        address = intent.getStringExtra("resCity");
        delivery_time= intent.getStringExtra("resOrder");
        min_order=intent.getStringExtra("resPrice");
        openingTime=intent.getStringExtra("resOpeningTime");
        closingTime=intent.getStringExtra("resClosingTime");

        recyclerView=findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}