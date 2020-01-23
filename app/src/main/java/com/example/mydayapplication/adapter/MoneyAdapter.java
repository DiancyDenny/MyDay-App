package com.example.mydayapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mydayapplication.R;
import com.example.mydayapplication.model.MoneyPostRequest;

import java.util.List;


public class MoneyAdapter extends RecyclerView.Adapter<MoneyAdapter.ViewHolder> {

    private List<MoneyPostRequest> lMoney;
    public int lastBal;

    public MoneyAdapter(List<MoneyPostRequest> moneyEntries) {
        lMoney = moneyEntries;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MoneyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View diaryView = inflater.inflate(R.layout.money_adapter_cardview, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(diaryView);
        return viewHolder;

    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MoneyAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        MoneyPostRequest moneyPostRequest = lMoney.get(position);

        // Set item views based on your views and data model

        TextView textViewID = viewHolder.txt_money_id;
        textViewID.setText(moneyPostRequest.getUserId().toString());

        TextView textViewDate = viewHolder.txt_date;
        textViewDate.setText(moneyPostRequest.getDate());

        if (moneyPostRequest.getDeposited() == 0) {

            TextView textViewDepWith = viewHolder.txt_depo_with;
            textViewDepWith.setText("Withdraw");

            TextView textViewAmt = viewHolder.txt_amt;
            textViewAmt.setText(moneyPostRequest.getWithdrawn().toString());
        } else {

            TextView textViewDepWith = viewHolder.txt_depo_with;
            textViewDepWith.setText("Deposit");

            TextView textViewAmt = viewHolder.txt_amt;
            textViewAmt.setText(moneyPostRequest.getDeposited().toString());
        }

        TextView textViewPurpose = viewHolder.txt_purpose;
        textViewPurpose.setText(moneyPostRequest.getPurpose());

        int lastBal = moneyPostRequest.getBalance();
    }

    public int lastBalance() {
        return lastBal;
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return lMoney.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public TextView txt_money_id;
        public TextView txt_date;
        public TextView txt_depo_with;
        public TextView txt_amt;
        public TextView txt_purpose;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            txt_money_id = (TextView) itemView.findViewById(R.id.txt_money_id);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_depo_with = (TextView) itemView.findViewById(R.id.txt_deposit_withdraw);
            txt_amt = (TextView) itemView.findViewById(R.id.txt_amount);
            txt_purpose = (TextView) itemView.findViewById(R.id.txt_purpose);
        }
    }
}