package com.example.mydayapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.mydayapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddMoneyActivity extends AppCompatActivity {


    private static Button date_range;
    private static TextView date_text_view;
    private static Calendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

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
                new DatePickerDialog(AddMoneyActivity.this, date, myCalendar
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

    public void saveAddMoney(View view) {
        Intent intent = new Intent(this, MyMoneyActivity.class);
        startActivity(intent);
    }
}

