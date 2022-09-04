package com.example.nepaleats.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nepaleats.models.Category;
import com.example.nepaleats.models.DataModel;
import com.example.nepaleats.R;
import com.example.nepaleats.models.Food;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Category> categoryArrayList;
    private ArrayList<Food> foodArrayList;
    private Context context;

    public ItemAdapter(Context context, ArrayList<Category> categoryArrayList){
        this.categoryArrayList=categoryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Category item = categoryArrayList.get(position);
        Log.d("sugam",item.getName());
        holder.mTextView.setText(item.getName());

        boolean isExpandable = item.isIs_category();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if(isExpandable){
            holder.mArrowImage.setImageResource(R.drawable.arrow_up);
        }else{
            holder.mArrowImage.setImageResource(R.drawable.arrow_downward);
        }

        NestedAdapter adapter = new NestedAdapter(context,item.getFood());
        holder.nestedRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedRecyclerView.setHasFixedSize(true);
        holder.nestedRecyclerView.setAdapter(adapter);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                model.setExpandable(!model.isExpandable());
//                list = model.getnestedList();
//                notifyItemChanged(holder.getAdapterPosition());


                item.setIs_category(!item.isIs_category());
                foodArrayList=item.getFood();
                notifyItemChanged(holder.getAdapterPosition());

            }
        });
    }


    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout linearLayout;
        private RelativeLayout expandableLayout;
        private TextView mTextView;
        private ImageView mArrowImage;
        private RecyclerView nestedRecyclerView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout=itemView.findViewById(R.id.expandable_layout);
            mTextView=itemView.findViewById(R.id.itemTv);
            mArrowImage=itemView.findViewById(R.id.arro_imageview);
            nestedRecyclerView=itemView.findViewById(R.id.child_rv);

        }
    }

}
