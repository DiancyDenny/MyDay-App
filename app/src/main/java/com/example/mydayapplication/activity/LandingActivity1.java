package com.example.mydayapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;

public class LandingActivity1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_1);

        Button btnStart = findViewById(R.id.act_landing1_btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LandingActivity2.class);
                startActivity(intent);
            }
        });
    }
}