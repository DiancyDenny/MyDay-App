package com.example.mydayapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mydayapplication.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class LandingActivity3 extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_3);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();

        SignInButton signInButton = findViewById(R.id.act_landing3_btn_signin);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(googleSignInOptions.getScopeArray());
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, RC_SIGN_IN);
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            loadMainActiivty();
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void loadMainActiivty() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void handleLaterLinkClick(View view) {
        Intent intent = new Intent(this, LandingActivity4.class);
        startActivity(intent);
    }
}