package com.example.android_sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android_sqldatabase.database.AppDatabase;
import com.example.android_sqldatabase.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);

//        Insert();
        Update(5);
        Delete(11);
        findUserTable();
    }

    private void Insert(){
        for(int i=0; i<10;i++){
            User ur = new User();
            ur.setUsername("Nguyen Van " + i);
            ur.setAddress("TB" + i);
            ur.setGender(1);
            db.userDao().Insert(ur);
        }
    }

    private void Update(int id){
        User ur = db.userDao().getUser(id);
        ur.setUsername("Do Hong Hanh");
        db.userDao().Update(ur);
        Log.d("TAG", "name : " + ur.username);
    }

    private void Delete(int id){
        User user = db.userDao().getUser(id);
        db.userDao().Delete(user);
    }

    private void findUserTable(){
        List<User> list = db.userDao().findUser(5);
        for(User model : list){
            Log.d("TAG", "name: " + model.username + "," +"address: " + model.address);
        }

    }


}