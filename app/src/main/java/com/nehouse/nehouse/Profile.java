package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends Activity {

    public static boolean logon = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    }

    public void ProfileConfirm (View view) {
        if (!logon) {           //если вызвана из settings
            logon = true;       //возвращаем флаг в предыдущее состояние
            finish();           //завершаем активность
        }
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
    }
}