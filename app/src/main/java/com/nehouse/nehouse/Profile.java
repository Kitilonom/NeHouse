package com.example.homeassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }

    public void ProfileConfirm (View view) {
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
    }
}
