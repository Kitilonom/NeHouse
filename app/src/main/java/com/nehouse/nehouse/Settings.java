package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        int ID = 0; // Вот тут надо вытащить ID из базы данных
        TextView userID = (TextView)this.findViewById(R.id.UserID); //переменная userID хранит TextView с id == "UserID"
        userID.setText("UserID: "+ ID);
    }

    public void SettingsProfile (View view) {
        Intent intent = new Intent(Settings.this, Profile.class);
        Profile.logon = false;
        startActivity(intent);
    }

    public void SettingsPassword (View view) {
        Intent intent = new Intent(Settings.this, PasswordChanging.class);
        Profile.logon = false;
        startActivity(intent);
    }

}
