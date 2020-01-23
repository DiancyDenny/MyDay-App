package com.example.mydayapplication.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mydayapplication.R;
import com.example.mydayapplication.adapter.DiaryAdapter;
import com.example.mydayapplication.business.DiaryBO;
import com.example.mydayapplication.model.MainResponse;
import com.example.mydayapplication.webservice.APIService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<MainResponse> arListDiary;
    private static Button date_range;
    private static TextView date_text_view;
    private static Calendar myCalendar;
    private DiaryAdapter adapter;

    GoogleSignInClient mGoogleSignInClient;
    Button sign_out;
    TextView nameTV;
    TextView emailTV;
    TextView idTV;
    ImageView photoIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // arListDiary = getAllDiaryEntries();
        arListDiary = new ArrayList<>();
        adapter = new DiaryAdapter(arListDiary);
        final RecyclerView rvDiary = findViewById(R.id.diary_recycler_view);
        rvDiary.setLayoutManager(new LinearLayoutManager(this));
        rvDiary.setAdapter(adapter);

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
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_write_diary);
        fab.setOnClickListener(new View.OnClickListener() {
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

        //Get API data and set it to recycler view

        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://backtowork.icfoss.qleapbs.com/diary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<List<MainResponse>> call = service.getDiaryData("1");
        call.enqueue(new Callback<List<MainResponse>>() {
            @Override
            public void onResponse(@NonNull Call<List<MainResponse>> call, @NonNull Response<List<MainResponse>> response) {
                if (response.body() != null) {
                    /*Toast.makeText(getApplicationContext(), "Got notes", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", response.body().toString());*/
                    arListDiary = response.body();
                    adapter = new DiaryAdapter(arListDiary);
                    rvDiary.setAdapter(adapter);
                    // adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Error in getting notes", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<MainResponse>> call, Throwable t) {
                Log.e("DiaryActivity", t.getMessage().toString());
                Toast.makeText(getApplicationContext(), "API Call Failure", Toast.LENGTH_LONG).show();
            }
        });

        //Google Sign-In Data

        sign_out = findViewById(R.id.log_out);
        nameTV = findViewById(R.id.name);
        emailTV = findViewById(R.id.email);
        idTV = findViewById(R.id.id);
        photoIV = findViewById(R.id.photo);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            Log.d("MainActivity", "Google" + personName + personEmail + personId);

           // nameTV.setText("Name: " + personName);
            //emailTV.setText("Email: " + personEmail);
            //idTV.setText("ID: " + personId);
            //Glide.with(this).load(personPhoto).into(photoIV);
        }

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

    }

    public ArrayList<MainResponse> getAllDiaryEntries() {
        ArrayList<MainResponse> arDataListDiary = new ArrayList<>(3);
        DiaryBO diaryBO = new DiaryBO();
        return diaryBO.getAllDiaryData();
    }

    //Updating textbox of calender
    private void updateLabel() {
        String myFormat = "MMM dd yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        date_text_view.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_settings_drawer, menu);
        return true;
    }

    //edit card view
    public void viewThisDay(View view) {
        Intent intent = new Intent(getApplicationContext(), NewDayActivity.class);
        startActivity(intent);

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this, "Successfully signed out", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, LandingActivity3.class));
                        finish();
                    }
                });
    }

 /*  public void changePasscode(View view) {
        EasyLock.changePassword(this, MainActivity.class);
    }

    public void removePasscode(View view) {
        EasyLock.disablePassword(this, MainActivity.class);
    }*/
}
