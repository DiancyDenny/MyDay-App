package com.example.mydayapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;

import p32929.easypasscodelock.Utils.EasyLock;

public class LandingActivity2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_2);

        EasyLock.setBackgroundColor(Color.rgb(51, 140, 198));
        EasyLock.checkPassword(this);
        EasyLock.forgotPassword(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LandingActivity2.this, "Clicked on forgot password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void handleSkipBtnClick(View view) {
        Intent intent = new Intent(this, LandingActivity3.class);
        startActivity(intent);
    }

    public void handleAddPasscodeBtnClick(View view) {
        EasyLock.setPassword(this, LandingActivity3.class);
    }
}