package com.example.homeassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
    }

    public void WelcomePageLogIn (View view) {
        Intent intent = new Intent(WelcomePage.this, MainActivity.class);
        startActivity(intent);
    }

    public void WelcomePageLogOn (View view) {
        Intent intent = new Intent(WelcomePage.this, LogOn.class);
        startActivity(intent);
    }

    public void WelcomePageForgot (View view) {
        Intent intent = new Intent(WelcomePage.this, ForgotPassword.class);
        startActivity(intent);
    }
}
