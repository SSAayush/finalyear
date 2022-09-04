package com.example.nepaleats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nepaleats.adapters.CartItemAdapter;
import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.app.NepalEats;
import com.example.nepaleats.database.models.CartItems;
import com.example.nepaleats.models.OrderModel;
import com.example.nepaleats.response.OrderResponse;
import com.example.nepaleats.viewmodel.CartViewModel;
import com.khalti.checkout.helper.Config;
import com.khalti.checkout.helper.OnCheckOutListener;
import com.khalti.checkout.helper.PaymentPreference;
import com.khalti.utils.Constant;
import com.khalti.widget.KhaltiButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartFragment extends Fragment {

    //Declaring variables
    private CartViewModel cartItemsViewModel;
    private RecyclerView rvCartItems;
    private CartItemAdapter adapter;
//    private LinearLayout ll_no_items;
    private ConstraintLayout rl_checkout;
    private List<CartItems> cartItemArrayList = new ArrayList<>();
    private Context context;
    private OrderModel orderModel;

    private Button btnCheckOut;
    private KhaltiButton khaltiButton;
    private TextView tv_totalPrice;
    double total_amount;

    String address;
    int res_id;

    ApiInterface apiInterface;




    public CartFragment() {
        // Required empty public constructor
    }


    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cartItemsViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        cartItemsViewModel.getAllItems().observe(this, new Observer<List<CartItems>>() {
            @Override
            public void onChanged(List<CartItems> cartItems) {
                Log.d("aayush", "Cart Items " + cartItems.size());
                if (cartItems.size() > 0) {
                    cartItemArrayList.addAll(cartItems);
                    adapter.update(cartItems);
//                    rvCartItems.setVisibility(View.VISIBLE);
//                    ll_no_items.setVisibility(View.GONE);
//                    rl_checkout.setVisibility(View.VISIBLE);
                    total_amount = 0;
                    for (CartItems item : cartItems) {
                        total_amount = total_amount + item.getTotal_price();
                        res_id = item.getRestaurant_id();
                        Log.d("resID", String.valueOf(res_id));
                    }
                    tv_totalPrice.setText(String.format("%.2f", total_amount));
//                    initOrder();
                } else {
//                    ll_no_items.setVisibility(View.VISIBLE);
//                    rvCartItems.setVisibility(View.GONE);
//                    rl_checkout.setVisibility(View.GONE);
                }

            }



        });
        initVars(root);
//        initKhalti();


        return root;



    }



    // this method is used for initilize view id
    private void initVars(View root) {

        tv_totalPrice = root.findViewById(R.id.tv_totalPrice);

        btnCheckOut = root.findViewById(R.id.btnCheckOut);
//        khalti_button= root.findViewById(R.id.khalti_button);
//        khaltiButton=root.findViewById(R.id.khalti_button);
        rl_checkout = root.findViewById(R.id.rl_checkout);
//        ll_no_items = root.findViewById(R.id.ll_no_items);
        rvCartItems = root.findViewById(R.id.rvCartItem);





        rvCartItems.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        rvCartItems.hasFixedSize();
        rvCartItems.setNestedScrollingEnabled(false);

        adapter = new CartItemAdapter(getActivity(), cartItemArrayList, new CartItemAdapter.CartItemListener() {
            @Override
            public void onClickAdd(CartItems item) {
                cartItemsViewModel.addQuantity(item);
            }

            @Override
            public void onClickMinus(CartItems item) {
                cartItemsViewModel.minusQuantity(item);
            }

            @Override
            public void onClickRemove(CartItems item) {
                cartItemsViewModel.removeItem(item);
            }
        });

        rvCartItems.setAdapter(adapter);

//        orderModel = new OrderModel();
//        orderModel.setUser_id(user_id);
//        orderModel.setRestaurant_id(restaurant_id);
//        orderModel.setTotal(amount);
//        orderModel.setOrderDetails(cartItemArrayList);

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (CartItems cartItems : cartItemArrayList){
                    cartItemsViewModel.removeItem(cartItems);
                }

                int user_id = NepalEats.prefs.getPrefs().getId();
                double amount = total_amount;
                int restaurant_id = NepalEats.appPref.getPrefs().getResturant_id();

                Intent intent = new Intent(getContext(),ManageAddressActivity.class);
                Bundle bundle=new Bundle();
                intent.putExtra("ResID",restaurant_id);
                intent.putExtra("Amount",amount);
                intent.putExtra("userID",user_id);
                bundle.putSerializable("list",(Serializable) cartItemArrayList );
                intent.putExtra("Bundle",bundle);
                Log.d("resID", String.valueOf(restaurant_id));
                Log.d("resID", String.valueOf(amount));
                Log.d("resID", String.valueOf(user_id));
                startActivity(intent);



//
//                if(cartItemArrayList.size()>0){
//                    Log.i("aayush", "Inside cartItemArrayList Order");
//

            }
        });
    }

    // this function is for payment method
    private void initKhalti() {
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