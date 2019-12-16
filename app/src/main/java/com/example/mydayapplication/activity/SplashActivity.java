package com.example.mydayapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, 3000);
    }

    private void startApp() {
        Intent intent = new Intent(SplashActivity.this, LandingActivity1.class);
        startActivity(intent);
        finish();
    }
}