package com.example.mydayapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;

import p32929.easypasscodelock.Utils.EasyLock;


public class Landing2Activity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing2);

        EasyLock.setBackgroundColor(Color.rgb( 51, 140, 198 ));
        EasyLock.checkPassword(this);

        EasyLock.forgotPassword(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Landing2Activity.this, "Clicked on forgot password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setPass(View view) {
        EasyLock.setPassword(this, Landing3Activity.class);
    }

    public void processSkipClick(View view) {
        Intent intent = new Intent(this, Landing3Activity.class);
        startActivity(intent);
    }
}
