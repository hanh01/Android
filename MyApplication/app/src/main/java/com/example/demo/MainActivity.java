package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    ImageView ivCover;
    EditText edPassword;
    EditText edUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvTitle = findViewById(R.id.tvTitle);
        ivCover = findViewById(R.id.ivCover);
        edUser = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);



        Button btLogin = findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","Click button");
                tvTitle.setText("Ahihi");
                ivCover.setImageResource(R.drawable.image1);
                String username = edUser.getText().toString();
                tvTitle.setText(username);
            }
        });
    }
}