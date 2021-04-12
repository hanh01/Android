package com.example.sqlite.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.IOnClickUser;
import com.example.sqlite.R;
import com.example.sqlite.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<User> listUser;
    private IOnClickUser iOnClickUser;

    public UserAdapter(Activity activity, List<User> listUser){
        this.activity = activity;
        this.listUser = listUser;
    }

    public void setiOnClickUser(IOnClickUser iOnClickUser) {
        this.iOnClickUser = iOnClickUser;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_news,parent,false);
        UserHolder holder = new UserHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserHolder user = (UserHolder) holder;
        User model = listUser.get(position);
        user.tvId.setText(String.valueOf(model.getId()));
        user.tvName.setText(model.getUsername());
        user.tvGender.setText(model.getGender());

    }

    @Override
    public int getItemCount() {

        return listUser.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder{

        TextView tvId, tvName, tvGender;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvGender = itemView.findViewById(R.id.tvGender);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MessageHolder", "onClick: "+getAdapterPosition());
                    User model = listUser.get(getAdapterPosition());
                    Log.d("MessageHolder", "name: "+model.getUsername());
                    iOnClickUser.onClickListener(model);
                }
            });
        }
    }
}
