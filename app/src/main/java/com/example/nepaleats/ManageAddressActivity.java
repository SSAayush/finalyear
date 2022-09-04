package com.example.nepaleats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.app.NepalEats;
import com.example.nepaleats.database.models.CartItems;
import com.example.nepaleats.models.OrderModel;
import com.example.nepaleats.response.OrderResponse;
import com.khalti.checkout.helper.Config;
import com.khalti.checkout.helper.OnCheckOutListener;
import com.khalti.checkout.helper.PaymentPreference;
import com.khalti.utils.Constant;
import com.khalti.widget.KhaltiButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageAddressActivity extends AppCompatActivity {

    private Button btnPlaceOrder;
    private EditText address;
    int restaurant_id, user_id;
    double amount;
    ApiInterface apiInterface;
    private KhaltiButton khaltiButton;
    private List<CartItems> cartItemArrayList = new ArrayList<>();
    private OrderModel orderModel = new OrderModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_address);

        getSupportActionBar().setTitle("Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intiVars();
        initKhalti();

//        khaltiButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("alex","muji");
//                if (address.getText().toString().isEmpty()) {
//                    Toast.makeText(ManageAddressActivity.this, "Fill as the deatils", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(ManageAddressActivity.this, "MUJI", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }



    private void intiVars() {
        khaltiButton = (KhaltiButton) findViewById(R.id.khalti_button);
        address = findViewById(R.id.address);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        restaurant_id = intent.getIntExtra("ResID", 0);
        amount = intent.getDoubleExtra("Amount", 0);
        user_id = intent.getIntExtra("userID", 0);
        Log.d("resID", String.valueOf(restaurant_id));
        Log.d("resID", String.valueOf(amount));
        Log.d("resID", String.valueOf(user_id));
        cartItemArrayList = (ArrayList<CartItems>) bundle.getSerializable("list");
    }

    public void orderAPI() {

        String address_detail = address.getText().toString();

        orderModel.setUser_id(user_id);
        orderModel.setRestaurant_id(restaurant_id);
        orderModel.setTotal(amount);
        orderModel.setAddress_details(address_detail);
        orderModel.setOrderDetails(cartItemArrayList);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<OrderResponse> call = apiInterface.order(orderModel);
        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                OrderResponse rs = response.body();
                if (rs != null) {
                    if (rs.isSuccess()) {

                        Toast.makeText(ManageAddressActivity.this,"Order Placed",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ManageAddressActivity.this, rs.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {
                Toast.makeText(ManageAddressActivity.this,"Server Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initKhalti(){
        Map<String, Object> map = new HashMap<>();
        map.put("merchant_extra", "This is extra data");

        Config config = new Config.Builder(
                Constant.pub,
                "Product ID",
                "Main",
                1100L, new OnCheckOutListener() {
            @Override
            public void onError(@NonNull String action, @NonNull Map<String, String> errorMap) {
                Log.i(action, errorMap.toString());
            }

            @Override
            public void onSuccess(@NonNull Map<String, Object> data) {
                // call api of order
                Log.i("success", data.toString());
                orderAPI();

            }
        }).paymentPreferences(new ArrayList<PaymentPreference>() {{
            add(PaymentPreference.KHALTI);
            add(PaymentPreference.EBANKING);
            add(PaymentPreference.MOBILE_BANKING);
            add(PaymentPreference.CONNECT_IPS);
            add(PaymentPreference.SCT);
        }})
                .additionalData(map)
                .productUrl("http://example.com/product")
                .mobile("9800000000")
                .build();
        khaltiButton.setCheckOutConfig(config);
    }
}
