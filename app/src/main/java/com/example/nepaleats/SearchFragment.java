package com.example.nepaleats;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nepaleats.adapters.RestaurantAdapter;
import com.example.nepaleats.adapters.SearchAdapter;
import com.example.nepaleats.api.ApiClient;
import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.models.Restaurant;
import com.example.nepaleats.response.SearchResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {
    ApiInterface apiInterface;
    private Button btnSearch;
    private EditText tvSearch;
    RecyclerView recyclerView;
    private SearchAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void apiCallSearch(String search){

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<SearchResponse> call = apiInterface.search(
                search
        );
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                SearchResponse rs = response.body();
                if(rs != null){
                    if(rs.isSuccess()){
                        setRecyclerView(rs.getData());
                    }
                }else{
                    Toast.makeText(getContext(),"No result found",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        btnSearch = view.findViewById(R.id.btnSearch);
        tvSearch = view.findViewById(R.id.tvSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Search = tvSearch.getText().toString();

                apiCallSearch(Search);
            }
        });

        return view;
    }

    private void setRecyclerView(ArrayList<Restaurant> restaurantArrayList) {
        adapter = new SearchAdapter(getActivity(), restaurantArrayList);
        recyclerView.setAdapter(adapter);
    }





}