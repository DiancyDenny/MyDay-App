package com.example.mydayapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mydayapplication.R;
import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.MainResponse;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    private List<MainResponse> lDiary;

    public DiaryAdapter(List<MainResponse> diaryEntries) {
        lDiary = diaryEntries;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public DiaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View diaryView = inflater.inflate(R.layout.main_adapter_cardview, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(diaryView);
        return viewHolder;

    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(DiaryAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        MainResponse mainResponse = lDiary.get(position);

        // Set item views based on your views and data model

        TextView textViewID = viewHolder.txt_diary_id;
        textViewID.setText(mainResponse.getId());

        TextView textViewDate = viewHolder.txt_date;
        textViewDate.setText(mainResponse.getDate());

        TextView textViewTitle = viewHolder.txt_title;
        textViewTitle.setText(mainResponse.getTitle());

        //Get first 25 letters of Desc
       String desc = mainResponse.getDescription();
        String trimDesc = "";
        if (desc.length() > 25)
            trimDesc = desc.substring(0, 25);
        else
            trimDesc = desc;

        TextView textViewData = viewHolder.txt_data;
        textViewData.setText(trimDesc+"...");

      /*  TextView textViewExpense = viewHolder.txt_expense;
        textViewExpense.setText(diary.getExpense().toString());*/
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return lDiary.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public TextView txt_diary_id;
        public TextView txt_date;
        public TextView txt_title;
        public TextView txt_data;
        public TextView txt_expense;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            txt_diary_id = (TextView) itemView.findViewById(R.id.txt_diary_id);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_data = (TextView) itemView.findViewById(R.id.txt_data);
            txt_expense = (TextView) itemView.findViewById(R.id.txt_expense);
        }
    }
}