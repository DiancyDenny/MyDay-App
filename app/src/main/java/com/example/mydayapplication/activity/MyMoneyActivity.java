package com.example.mydayapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mydayapplication.R;
import com.example.mydayapplication.adapter.DiaryAdapter;
import com.example.mydayapplication.adapter.MoneyAdapter;
import com.example.mydayapplication.business.DiaryBO;
import com.example.mydayapplication.business.MoneyBO;
import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.MoneyPostRequest;

import java.util.ArrayList;

public class MyMoneyActivity extends AppCompatActivity {

    ArrayList<MoneyPostRequest> arListMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_money);

        // Lookup the recyclerview in activity layout
        RecyclerView rvMoney = (RecyclerView) findViewById(R.id.money_recycler_view);

        // Set layout manager to position the items
        rvMoney.setLayoutManager(new LinearLayoutManager(this));

        //Get the daily money notes from MoneyBO
        arListMoney = getAllMoneyEntries();

        // Create adapter passing in the sample diary data
        MoneyAdapter moneyAdapter = new MoneyAdapter(arListMoney);
        rvMoney.setAdapter(moneyAdapter);

        //display last balance
        /*int bal = moneyAdapter.lastBalance();
        EditText txt_bal = findViewById(R.id.txt_balance);
        txt_bal.setText(bal);*/
    }

    public ArrayList<MoneyPostRequest> getAllMoneyEntries() {
        ArrayList<MoneyPostRequest> arrayList = new ArrayList<>(3);
        MoneyBO moneyBO = new MoneyBO();
        return moneyBO.getAllMoneyData();
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
