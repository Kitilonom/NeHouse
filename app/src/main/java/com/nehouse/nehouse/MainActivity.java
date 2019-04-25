package com.example.homeassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		Intent intent = new Intent(MainActivity.this, WelcomePage.class);
        startActivity(intent);
    }

    public void MainActivityCalendar (View view) {
        Intent intent = new Intent(MainActivity.this, Calendar.class);
        startActivity(intent);
    }
}
