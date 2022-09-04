package com.example.nepaleats.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nepaleats.R;
import com.example.nepaleats.RestaurantDetailsActivity;
import com.example.nepaleats.SearchFragment;
import com.example.nepaleats.models.Restaurant;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.Viewholder> {
    private ArrayList<Restaurant> restaurantsList;
    private Context context;


    public SearchAdapter(Context context, ArrayList<Restaurant> restaurantsList){
        this.context = context;
        this.restaurantsList= restaurantsList;
    }

    @NonNull
    @Override
    public SearchAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.search_item, parent, false);
        Viewholder viewholder = new Viewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.Viewholder holder, int position) {
        Restaurant restaurant = restaurantsList.get(position);
        holder.tvRestaurantName.setText(restaurant.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantDetailsActivity.class);
//                intent.putExtra("imgResturant",item.getImgRestaurant());
                intent.putExtra("resId",restaurant.getId());
                intent.putExtra("resName",restaurant.getName());
                intent.putExtra("resCity",restaurant.getAddress());
                intent.putExtra("resOrder",restaurant.getDelivery_time());
                intent.putExtra("resPrice",restaurant.getMin_order());
                intent.putExtra("resOpeningTime",restaurant.getOpening_time());
                intent.putExtra("resClosingTime",restaurant.getClosing_time());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgRestaurant;
        TextView  tvRestaurantName;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgRestaurant = itemView.findViewById(R.id.imgRestaurant);
            tvRestaurantName = itemView.findViewById(R.id.tvRestaurantName);
        }
    }
}
