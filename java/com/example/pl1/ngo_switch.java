package com.example.pl1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pl1.Adoptview.adoptview;
import com.example.pl1.Adoptview.petdisplay.petdisplay;

public class ngo_switch extends AppCompatActivity {
    Button adopt, donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngo_switch);
    donate=(Button)findViewById(R.id.button7);
    adopt=(Button)findViewById(R.id.button8);
    adopt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentad=new Intent(ngo_switch.this, adoptview.class);
        startActivity(intentad);
        }
    });
    donate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentd=new Intent(ngo_switch.this, petdisplay.class);
            startActivity(intentd);
        }
    });
    }
}
