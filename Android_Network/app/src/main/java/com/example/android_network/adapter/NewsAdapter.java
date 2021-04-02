package com.example.android_network.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_network.R;
import com.example.android_network.model.Item;

import org.w3c.dom.Text;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Item> list;

    //Tao constructor = Generate
    public NewsAdapter(Activity activity, List<Item> list){
        this.activity = activity;
        this.list = list;
    }

    public void reloadData(List<Item> list){
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_news,parent,false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Item model = list.get(position);
        vh.tvTitle.setText(model.getTitle());
        vh.tvDes.setText(model.getContent().getDescription());
        vh.tvDate.setText(model.getDate());
        Glide.with(activity).load(model.getImage()).into(vh.ivCover);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvDate, tvTitle, tvDes;
        ImageView ivCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}
