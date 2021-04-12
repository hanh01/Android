package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sqlite.database.AppDatabase;
import com.example.sqlite.entity.User;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText edUsername, edDescription;
    CheckBox ck;
    Button btRegister;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        edUsername = findViewById(R.id.edUsername);
        edDescription = findViewById(R.id.edDescription);
        ck = findViewById(R.id.ck);
        btRegister = findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(v == btRegister)
                onRegister();
            }
        });

        initView();


    }

    private void initView(){
        String [] genders = {"Male", "Female", "Unknow"};
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void onRegister(){
        Intent register = new Intent(MainActivity.this,ListUserActivity.class);
        AddUser();
        startActivity(register);
    }

    private void AddUser(){
        User user = new User();
        user.setUsername(edUsername.getText().toString());
        user.setGender(spinner.getSelectedItem().toString());
        user.setDescription(edDescription.getText().toString());
        db.userDao().Insert(user);
    }

}