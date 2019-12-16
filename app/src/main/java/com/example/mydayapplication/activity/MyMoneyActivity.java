package com.example.mydayapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydayapplication.R;

public class MyMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_money);
    }
    public void addMoney(View view) {
        Intent intent = new Intent(this, AddMoneyActivity.class);
        startActivity(intent);
    }
    public void removeMoney(View view) {
        Intent intent = new Intent(this, RemoveMoneyActivity.class);
        startActivity(intent);
    }
}
