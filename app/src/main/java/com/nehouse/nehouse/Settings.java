package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nehouse.nehouse.Model.User;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        TextView userID = (TextView)this.findViewById(R.id.UserID); //переменная userID хранит TextView с id == "UserID"
        TextView name = (TextView)this.findViewById(R.id.AccName);
        TextView bday = (TextView)this.findViewById(R.id.AccDateOfBirth);
        TextView email = (TextView)this.findViewById(R.id.AccProfileEmail);
        TextView phone = (TextView)this.findViewById(R.id.AccProfilePhone);
        TextView group = (TextView)this.findViewById(R.id.GroupName);

        userID.setTextColor(getResources().getColor(R.color.colorWhite));
        name.setTextColor(getResources().getColor(R.color.colorWhite));
        bday.setTextColor(getResources().getColor(R.color.colorWhite));
        email.setTextColor(getResources().getColor(R.color.colorWhite));
        phone.setTextColor(getResources().getColor(R.color.colorWhite));
        group.setTextColor(getResources().getColor(R.color.colorWhite));

        userID.setText("UserID: " + System.getProperty("line.separator") + MainActivity.currentUser.getUid());
        name.setText("Name: " + MainActivity.user.getName());
        bday.setText("DateOfBirth: " + MainActivity.user.getBday());
        email.setText("Email: " + MainActivity.user.getEmail());
        phone.setText("Phone: " + MainActivity.user.getPhone());
        group.setText("Group: " + MainActivity.user.getGroupID());
    }

    public void SettingsEditProfile (View view) {
        Intent intent = new Intent(Settings.this, Profile.class);
        Profile.logon = false;
        startActivity(intent);
    }

    public void SettingsLogOut (View view) {
        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(Settings.this, WelcomePage.class);
        startActivity(intent);
    }

}
