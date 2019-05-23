package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.nehouse.nehouse.Model.User;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

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
        EditText ETname = findViewById(R.id.Name);
        EditText ETDateOfBirth = findViewById(R.id.DateOfBirth);
        EditText ETProfilePhone = findViewById(R.id.ProfilePhone);
        String name = ETname.getText().toString();
        String DateOfBirth = ETDateOfBirth.getText().toString();
        String ProfilePhone = ETProfilePhone.getText().toString();

        if (Check(name, DateOfBirth, ProfilePhone)) {
            updateUInfo(name, DateOfBirth, ProfilePhone);
            Intent intent = new Intent(Profile.this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void updateUInfo(String name, String dateOfBirth, String phone) {
        String key = MainActivity.user.getId();

        String id = MainActivity.user.getId();
        String email = MainActivity.user.getEmail();
        String password = MainActivity.user.getPassword();
        String group = MainActivity.user.getGroupID();
        User user = new User(id, name, phone, email, password, group, dateOfBirth);
        Map<String, Object> userMap = user.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(key, userMap);

        MainActivity.usersDB.updateChildren(childUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Profile.this, "Update succesfull.",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private boolean Check(String name, String dateOfBirth, String profilePhone) {
        if (name.isEmpty() || dateOfBirth.isEmpty() || profilePhone.isEmpty()) {
            Toast.makeText(Profile.this, "All fileds are required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
