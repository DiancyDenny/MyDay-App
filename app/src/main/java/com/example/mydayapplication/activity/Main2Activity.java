package com.example.mydayapplication.activity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydayapplication.R;
import com.example.mydayapplication.adapter.DiaryAdapter;
import com.example.mydayapplication.business.DiaryBO;
import com.example.mydayapplication.model.Diary;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Diary> arListDiary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Lookup the recyclerview in activity layout
        RecyclerView rvDiary = (RecyclerView) findViewById(R.id.diary_recycler_view);
        arListDiary = getAllDiaryEntries();

        // Set layout manager to position the items
        rvDiary.setLayoutManager(new LinearLayoutManager(this));

        // Create adapter passing in the sample dishes data
        DiaryAdapter adapter = new DiaryAdapter(arListDiary);
        rvDiary.setAdapter(adapter);


    }
    public ArrayList<Diary> getAllDiaryEntries(){
        ArrayList<Diary> arDataListDiary = new ArrayList<>(3);
        DiaryBO diaryBO = new DiaryBO();
        return diaryBO.getAllDiaryData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }
}
