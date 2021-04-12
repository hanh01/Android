package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.adapter.UserAdapter;
import com.example.sqlite.database.AppDatabase;
import com.example.sqlite.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserActivity extends AppCompatActivity {

    RecyclerView rvUser;
    List<User> listUser = new ArrayList<>();
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        db = AppDatabase.getAppDatabase(this);

        //Data source
        listUser = db.userDao().getAll();

        //Layout manager
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        //Adapter
        UserAdapter adapter = new UserAdapter(this, listUser);
        adapter.setiOnClickUser(new IOnClickUser() {
            @Override
            public void onClickListener(User user) {
                Toast.makeText(ListUserActivity.this,user.getUsername(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListUserActivity.this,UpdateActivity.class);
                intent.putExtra("Name", user.getUsername());
                intent.putExtra("Gender",user.getGender());
                intent.putExtra("Description",user.getDescription());
                intent.putExtra("Id",user.getId());
                startActivity(intent);
            }
        });

        //RecycleView
        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);
    }

}