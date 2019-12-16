package com.example.mydayapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.mydayapplication.R;
import com.example.mydayapplication.adapter.DiaryAdapter;
import com.example.mydayapplication.business.DiaryBO;
import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.DiaryResponse;
import com.example.mydayapplication.model.MainRequest;
import com.example.mydayapplication.model.MainResponse;
import com.example.mydayapplication.webservice.APIService;
import com.example.mydayapplication.webservice.RetrofitAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ArrayList<DiaryRequest> arListDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Lookup the recyclerview in activity layout
        RecyclerView rvDiary = (RecyclerView) findViewById(R.id.diary_recycler_view);
        arListDiary = getAllDiaryEntries();

        // Set layout manager to position the items
        rvDiary.setLayoutManager(new LinearLayoutManager(this));

        // Create adapter passing in the sample dishes data
        DiaryAdapter adapter = new DiaryAdapter(arListDiary);
        rvDiary.setAdapter(adapter);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_write_diary);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewDayActivity.class);
                startActivity(intent);

            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_money_bag);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyMoneyActivity.class);
                startActivity(intent);

            }
        });
    }

    public ArrayList<DiaryRequest> getAllDiaryEntries(){
        ArrayList<DiaryRequest> arDataListDiary = new ArrayList<>(3);
        DiaryBO diaryBO = new DiaryBO();
        return diaryBO.getAllDiaryData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    //edit card view
    public void viewThisDay(View view) {

        Retrofit r;
        RetrofitAPI retrofitAPI = new RetrofitAPI();
        r = retrofitAPI.getRetrofit();

        APIService service = r.create(APIService.class);

        MainRequest mainRequest = new MainRequest();
        mainRequest.setUserId(1);

        Call<MainResponse> call = service.viewDiaryData(mainRequest);
        call.enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(@NonNull Call<MainResponse> call, @NonNull Response<MainResponse> response) {
                if (response.body() != null) {
                    if (response.body().getTitle() != null) {
                         Intent intent = new Intent(getApplicationContext(), NewDayActivity.class);
                         startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error in creating daily note", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MainResponse> call, Throwable t) {
                Log.e("DiaryActivity", t.getMessage().toString());
                Toast.makeText(getApplicationContext(), "API Call Failure", Toast.LENGTH_LONG).show();
            }
        });

    }
}
