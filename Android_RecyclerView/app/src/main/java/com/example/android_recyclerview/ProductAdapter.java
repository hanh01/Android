package com.example.android_recyclerview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Product> listProduct;

    public ProductAdapter(Activity activity, List<Product> listProduct){
        this.activity = activity;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    // yeu cau tao 1 class ViewHolder
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.activity_product,parent,false);
        ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder vh = (ProductHolder) holder;
        Product model = listProduct.get(position);
        vh.ivImage.setImageResource(model.getImg());
        vh.tvName.setText(model.getName());
        vh.tvPrice.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }


    //class dc tao ke thua tu RecyclerView
    public class ProductHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvName,tvPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImg);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}
