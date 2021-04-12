package com.demo.ss4;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Message> listMessage;
    private IOnClickMessage iOnClickMessage;

    public MessageAdapter(Activity activity, List<Message> listMessage) {
        this.activity = activity;
        this.listMessage = listMessage;
    }

    public void setiOnClickMessage(IOnClickMessage iOnClickMessage) {
        this.iOnClickMessage = iOnClickMessage;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_message, parent, false);
        MessageHolder holder = new MessageHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageHolder vh = (MessageHolder) holder;
        Message model = listMessage.get(position); //
        vh.ivAvatar.setImageResource(model.getAvatar());
        vh.tvUser.setText(model.getName());
        vh.tvContent.setText(model.getContent());
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    public class MessageHolder extends RecyclerView.ViewHolder {

        ImageView ivAvatar;
        TextView tvUser, tvContent;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvContent = itemView.findViewById(R.id.tvContent);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MessageHolder", "onClick: "+getAdapterPosition());
                    Message model = listMessage.get(getAdapterPosition());
                    Log.d("MessageHolder", "name: "+model.getName());
                    iOnClickMessage.onClickListener(model);
                }
            });

        }
    }
}
