package com.example.homeassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ForgotPassword  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
    }

    public void ForgotPasswordConfirm (View view) {
        Intent intent = new Intent(ForgotPassword.this, PasswordChanging.class);
        startActivity(intent);
    }
}
