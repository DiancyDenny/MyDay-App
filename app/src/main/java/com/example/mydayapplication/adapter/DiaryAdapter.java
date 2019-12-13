package com.example.mydayapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mydayapplication.R;
import com.example.mydayapplication.model.Diary;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    private List<Diary> lDiary;

    public DiaryAdapter(List<Diary> diaryEntries) {
        lDiary = diaryEntries;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public DiaryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View diaryView = inflater.inflate(R.layout.cards_layout, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(diaryView);
        return viewHolder;

    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(DiaryAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Diary diary = lDiary.get(position);
        // Set item views based on your views and data model
        TextView textViewDate = viewHolder.txt_date;
        textViewDate.setText(diary.getDate());

        TextView textViewTitle = viewHolder.txt_title;
        textViewTitle.setText(diary.getTitle());

        TextView textViewData = viewHolder.txt_data;
        textViewData.setText(diary.getData());

        TextView textViewExpense = viewHolder.txt_expense;
        textViewExpense.setText(diary.getExpense().toString());
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
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_data = (TextView) itemView.findViewById(R.id.txt_data);
            txt_expense = (TextView) itemView.findViewById(R.id.txt_expense);
        }
    }
}