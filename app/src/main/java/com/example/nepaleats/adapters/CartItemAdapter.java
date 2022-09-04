package com.example.nepaleats.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nepaleats.R;
import com.example.nepaleats.database.models.CartItems;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {
    private Context context;
    private List<CartItems> cartItems;
    private CartItemListener listener;
    private LayoutInflater inflater;

    public CartItemAdapter(Context context, List<CartItems> cartItems, CartItemListener listener) {
        this.context = context;
        this.cartItems = cartItems;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_cart, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
        CartItems cartItem = cartItems.get(position);
        holder.tvItemname.setText(cartItem.getName());
        holder.tvPrice.setText(String.valueOf(cartItem.getPrice()));
        holder.tvQty.setText(String.valueOf(cartItem.getQty()));

        Log.d("aayush", "Item ID ==> " + cartItem.getItem_id() + " Price ==>" + cartItem.getPrice() + " Total Amount ==>" + cartItem.getTotal_price());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPrice, tvItemname, tvQty;
        private Button btnAdd, btnMinus;
        private ImageButton btnRemove;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvItemname = itemView.findViewById(R.id.tv_itemName);
            tvQty = itemView.findViewById(R.id.tv_quantity);
            btnAdd = itemView.findViewById(R.id.btn_add);
            btnMinus = itemView.findViewById(R.id.btn_minus);
            btnRemove = itemView.findViewById(R.id.btn_remove);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CartItems item = cartItems.get(getAdapterPosition());
                    if (listener != null) {
                        listener.onClickAdd(item);
                    }
                }
            });

            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CartItems item = cartItems.get(getAdapterPosition());
                    if (listener != null) {
                        listener.onClickMinus(item);
                    }

                }
            });

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CartItems item = cartItems.get(getAdapterPosition());
                    if (listener != null) {
                        listener.onClickRemove(item);
                    }
                }
            });
        }
    }

    public void update(List<CartItems> updatedItems) {
        cartItems.clear();
        cartItems.addAll(updatedItems);
        notifyDataSetChanged();

    }

    public interface CartItemListener {
        void onClickAdd(CartItems item);

        void onClickMinus(CartItems item);

        void onClickRemove(CartItems item);

    }
}
