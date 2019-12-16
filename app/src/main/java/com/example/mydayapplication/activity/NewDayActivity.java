package com.example.mydayapplication.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;
import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.DiaryResponse;
import com.example.mydayapplication.webservice.APIService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewDayActivity extends AppCompatActivity {


    private static Button date_range;
    private static TextView date_text_view;
    private static Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_day);

       /* String date_str = new SimpleDateFormat("MMM dd yyyy", Locale.getDefault()).format(new Date());
        date_text_view.setText(date_str);*/

        //Date Operation
        date_range = (Button) findViewById(R.id.date_picker);
        date_text_view = (TextView) findViewById(R.id.txt_date_picked);
        myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        date_range.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(NewDayActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    //Updating textbox of calender
    private void updateLabel() {
        String myFormat = "MMM dd yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        date_text_view.setText(sdf.format(myCalendar.getTime()));
    }

    public void saveThisDay(View view) {
        TextView date_picked = findViewById(R.id.txt_date_picked);
        EditText title = findViewById(R.id.txt_title);
        EditText description = findViewById(R.id.txt_description);

        String date_ = date_picked.getText().toString();
        String title_ = title.getText().toString();
        String description_ = description.getText().toString();

        DiaryRequest diaryRequest = new DiaryRequest();
        diaryRequest.setUserId(1);
        diaryRequest.setDate(date_);
        diaryRequest.setTitle(title_);
        diaryRequest.setDesc(description_);
        // diaryRequest.setExpense(2500);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://backtowork.icfoss.qleapbs.com/diary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<DiaryResponse> call = service.createDiaryData(diaryRequest);
        call.enqueue(new Callback<DiaryResponse>() {
            @Override
            public void onResponse(@NonNull Call<DiaryResponse> call, @NonNull Response<DiaryResponse> response) {
                if (response.body() != null) {
                    if (response.body().getStatus()) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error in creating daily note", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DiaryResponse> call, Throwable t) {
                Log.e("DiaryActivity", t.getMessage().toString());
                Toast.makeText(getApplicationContext(), "API Call Failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}