package com.example.pl1.Overviews;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pl1.R;
import com.example.pl1.ui.login.LoginActivity;

public class second extends
        Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_first);
        Button skip=(Button)findViewById(R.id.skip);
        Button next=(Button)findViewById(R.id.next);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getApplicationContext(), third.class);
                startActivity(intent2);
            }
        });
    }
}