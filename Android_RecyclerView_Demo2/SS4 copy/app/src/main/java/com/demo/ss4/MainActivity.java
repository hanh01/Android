package com.demo.ss4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMessage;
    List<Message> listMessage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        //B1: Data source
        initData();

        //B2: Layout Manager
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        //B3: Adapter
        MessageAdapter adapter = new MessageAdapter(this, listMessage);

        //B4: RecyclerView
        rvMessage = findViewById(R.id.rvMessage);
        rvMessage.setLayoutManager(layoutManager);
        rvMessage.setAdapter(adapter);
    }

    private void initData() {
//        Message mes = new Message();
//        mes.setName("Nguyen Van A");
//        mes.setContent("Anh yeu em");
//        mes.setAvatar(R.drawable.ic_avatar1);
        listMessage.add(new Message("Nguyen Van A", " Anh yeu em 1", R.drawable.ic_avatar1));
        listMessage.add(new Message("Nguyen Van B", " Anh yeu em 2", R.drawable.ic_avatar2));
        listMessage.add(new Message("Nguyen Van C", " Anh yeu em 3", R.drawable.ic_avatar3));
        listMessage.add(new Message("Nguyen Van D", " Anh yeu em", R.drawable.ic_avatar4));
        listMessage.add(new Message("Nguyen Van E", " Anh yeu em", R.drawable.ic_avatar1));
        listMessage.add(new Message("Nguyen Van F", " Anh yeu em", R.drawable.ic_avatar2));
        listMessage.add(new Message("Nguyen Van G", " Anh yeu em", R.drawable.ic_avatar3));
        listMessage.add(new Message("Nguyen Van H", " Anh yeu em", R.drawable.ic_avatar4));
        listMessage.add(new Message("Nguyen Van I", " Anh yeu em", R.drawable.ic_avatar1));
    }
}