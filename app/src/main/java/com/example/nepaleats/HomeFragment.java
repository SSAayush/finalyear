package com.example.nepaleats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nepaleats.app.NepalEats;
import com.example.nepaleats.models.Restaurant;
import com.example.nepaleats.response.RestaurantResponse;
import com.example.nepaleats.adapters.RestaurantAdapter;
import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private MaterialTextView name , address,delivery_time ,minOrder;
    private ApiInterface apiInterface;
    private ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
    private RestaurantAdapter adapter;
    private TextView tvWelcome;

    public HomeFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //View v= inflater.inflate(R.layout.fragment_more, container, false);

//        homeModelArrayList = new ArrayList<>();
//
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re1, "Smoking Yak", "Lake Side", "Min Order", "Rs 200"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re2, "Chicken Station", "New Road", "Min Order", "Rs 150"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re3, "Crave", "New Road", "Min Order", "Rs 250"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re4, "Angan", "New Road", "Min Order", "Rs 100"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re5, "Almonds", "New Road", "Min Order", "Rs 250"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re6, "Pizmo", "Samsung Galli", "Min Order", "Rs 100"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re7, "Samya", "Khapaudi", "Min Order", "Rs 270"));
//        homeModelArrayList.add(new HomeModel(R.drawable.img_re8, "Road House", "Lake Side", "Min Order", "Rs 300"));






    }


    private void apiCallRestaurant() {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RestaurantResponse> call=apiInterface.getAllRestaurant();
        call.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                RestaurantResponse rs = response.body();
                if(rs != null){
                    if(rs.isSuccess()){
                        setRecyclerView(rs.getData());
                    }
//                    Intent intent = new Intent(getContext(), RestaurantDetails.class);
//                    startActivity(intent);
                }
            }
            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
            }
        });
        }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tvWelcome= view.findViewById(R.id.tvWelcome);
        recyclerView = view.findViewById(R.id.recyclerHome);
        recyclerView.setHasFixedSize(true); 
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), RestaurantDetails.class);
//                startActivity(intent);
//            }
//        });

        apiCallRestaurant();
        setWelcomeMessage();
        return view;
    }

    private void setWelcomeMessage() {
        tvWelcome.setText("Welcome " +NepalEats.prefs.getPrefs().getName());


    }

    private void setRecyclerView(ArrayList<Restaurant> restaurantArrayList) {
        adapter = new RestaurantAdapter(getActivity(), restaurantArrayList);
        recyclerView.setAdapter(adapter);
    }


}

