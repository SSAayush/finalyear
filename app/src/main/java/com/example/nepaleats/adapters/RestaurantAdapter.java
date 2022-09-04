package com.example.nepaleats.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nepaleats.managers.PrefManager;
import com.example.nepaleats.models.Restaurant;
import com.example.nepaleats.R;
import com.example.nepaleats.RestaurantDetailsActivity;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private ArrayList<Restaurant> reList;
    private Context context;

    public RestaurantAdapter(Context context, ArrayList<Restaurant> reList) {
        this.context = context;
        this.reList = reList;
    }


    @NonNull
    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.restaurant_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        Restaurant item = reList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.tvMinOrderValue.setText(item.getMin_order());
        holder.tvDeliveryTime.setText(item.getDelivery_time());
        Log.d("alex",String.valueOf(item.getId()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefManager.setRestaurantID(item.getId());
                Intent intent = new Intent(context, RestaurantDetailsActivity.class);
//                intent.putExtra("imgResturant",item.getImgRestaurant());
                intent.putExtra("resId",item.getId());
                intent.putExtra("resName",item.getName());
                intent.putExtra("resCity",item.getAddress());
                intent.putExtra("resOrder",item.getDelivery_time());
                intent.putExtra("resPrice",item.getMin_order());
                intent.putExtra("resOpeningTime",item.getOpening_time());
                intent.putExtra("resClosingTime",item.getClosing_time());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRestaurant;
        TextView tvName,tvAddress,tvDeliveryTime,tvMinOrderValue;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRestaurant = itemView.findViewById(R.id.ivRestaurant);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvDeliveryTime = itemView.findViewById(R.id.tvDeliveryTime);
            tvMinOrderValue = itemView.findViewById(R.id.tvMinOrderValue);

        }
    }
}

