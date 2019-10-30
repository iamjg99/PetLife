package com.example.pl1.Overviews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pl1.R;
import com.example.pl1.ui.login.LoginActivity;


public class third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_second);
        Button skip=(Button)findViewById(R.id.skip2);
        Button next=(Button)findViewById(R.id.next2);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent3);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getApplicationContext(), fourth.class);
                startActivity(intent4);
            }
        });
    }
}