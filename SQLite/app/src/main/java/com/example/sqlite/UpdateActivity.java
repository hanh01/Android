package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sqlite.database.AppDatabase;
import com.example.sqlite.entity.User;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    AppDatabase db;
    EditText edName,edDes,edGender;
    Button btUpdate,btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = AppDatabase.getAppDatabase(this);

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("Id",0);
        String name = intent.getStringExtra("Name");
        String gender = intent.getStringExtra("Gender");
        String description = intent.getStringExtra("Description");

        edName = findViewById(R.id.edName);
        edGender = findViewById(R.id.edGender);
        edDes = findViewById(R.id.edDes);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);


        edName.setText(name);
        edGender.setText(gender);
        edDes.setText(description);

        InitView();

    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        Integer id = intent.getIntExtra("Id",0);
        switch (v.getId()){
            case R.id.btUpdate:
                onUpdate(id);
                break;
            case R.id.btDelete:
                onDelete(id);
                break;
            default:
                break;
        }
    }

    private void InitView(){
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
    }


    private void onUpdate(int id){
        User user = db.userDao().getUser(id);
        user.setUsername(edName.getText().toString());
        user.setGender(edGender.getText().toString());
        user.setDescription(edDes.getText().toString());
        db.userDao().Update(user);

        Intent update = new Intent(UpdateActivity.this,ListUserActivity.class);
        startActivity(update);
    }

    private void onDelete(int id){
        User user = db.userDao().getUser(id);
        db.userDao().Delete(user);

        Intent delete = new Intent(UpdateActivity.this,ListUserActivity.class);
        startActivity(delete);
    }

}