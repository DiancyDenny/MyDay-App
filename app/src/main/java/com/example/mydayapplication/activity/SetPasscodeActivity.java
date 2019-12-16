package com.example.mydayapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.mydayapplication.R;

import p32929.easypasscodelock.Utils.EasyLock;
import p32929.easypasscodelock.Utils.LockscreenHandler;

public class SetPasscodeActivity extends LockscreenHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_passcode);

        EasyLock.setBackgroundColor(Color.rgb(51, 140, 198));
        EasyLock.checkPassword(this);
    }

    public void setPass(View view) {
        EasyLock.setPassword(this, MainActivity.class);
    }

    public void changePass(View view) {
        EasyLock.changePassword(this, MainActivity.class);
    }

    public void disable(View view) {
        EasyLock.disablePassword(this, MainActivity.class);
    }

    public void checkPass(View view) {
        EasyLock.checkPassword(this);
    }
}