package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogOn extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_on);
    }

    public void LogOnLogOn (View view) {
        Intent intent = new Intent(LogOn.this, Profile.class);
        startActivity(intent);
    }
}
