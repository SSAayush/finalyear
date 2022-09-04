package com.example.nepaleats.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nepaleats.R;
import com.example.nepaleats.api.Api;
import com.example.nepaleats.managers.CartManager;
import com.example.nepaleats.models.Food;
import com.example.nepaleats.models.ProductItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.NestedViewHolder> {

    private ArrayList<Food> foodArrayList;
    private Context context;

    public NestedAdapter(Context context, ArrayList<Food> foodArrayList){
        this.context = context;
        this.foodArrayList = foodArrayList;
        Log.d("aayush",String.valueOf(foodArrayList.size()));
    }

    @NonNull
    @Override
    public NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nested_item , parent , false);
        return new NestedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedViewHolder holder, int position) {
        Food item = foodArrayList.get(position);
        holder.mTv.setText(item.getName());
//        Picasso.get().load(Api.getImageFromUrl(item.getUrl())).into(holder.imgFood);
        Log.d("aayush",String.valueOf(item.getUrl()));
        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Food food=new Food();
                ProductItem cartItem =new ProductItem();
                cartItem.setId(item.getId());
                cartItem.setName(item.getName());
                cartItem.setPrice(Double.parseDouble(item.getPrice()));
                cartItem.setRestaurant_id(item.getRestaurant_id());

                Log.d("aayushh",item.getName());
                Log.d("aayushh",String.valueOf(item.getRestaurant_id()));
                CartManager.addToCart(context,cartItem);
                Toast.makeText(context,String.format("%s added to cart",cartItem.getName()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return foodArrayList.size();
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder{
        private TextView mTv;
        private Button btnAddToCart;
        private ImageView imgFood;
        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.nestedItemTv);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);


//            imgFood= itemView.findViewById(R.id.imgFood);


        }
    }

}
