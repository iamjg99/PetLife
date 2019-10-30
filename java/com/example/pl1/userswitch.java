package com.example.pl1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pl1.Adoptview.adoptview;
import com.example.pl1.Adoptview.petdisplay.petdisplay;

import static android.view.View.*;


public class userswitch extends AppCompatActivity {
    Button adopt, donate, developer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userswitch);
        Button adopt = (Button) findViewById(R.id.button2);
        Button donate = (Button) findViewById(R.id.button3);
        developer = (Button) findViewById(R.id.developer);
        adopt.setOnClickListener((View view) -> {
            Intent intentadopt = new Intent(getApplicationContext(), adoptview.class);
            startActivity(intentadopt);
        });
        donate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdonate = new Intent(getApplicationContext(), donate.class);
                startActivity(intentdonate);
            }
        });
        developer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent Intentdev=new Intent(userswitch.this, ngo_switch.class);
               startActivity(Intentdev);
            }
        });
    }
}
