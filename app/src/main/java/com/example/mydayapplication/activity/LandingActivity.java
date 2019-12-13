package com.example.mydayapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;


public class LandingActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        Button btn_start = findViewById(R.id.btn_landing_start);

        btn_start.setOnClickListener(new View.OnClickListener() { //anonymous inner class
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Landing2Activity.class);
                startActivity(intent);
            }
        });
    }
}
