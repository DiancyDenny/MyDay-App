package com.example.mydayapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mydayapplication.R;

public class RemoveMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_money);
    }

    public void saveRemoveMoney(View view) {
        Intent intent = new Intent(this, MyMoneyActivity.class);
        startActivity(intent);
    }
}
