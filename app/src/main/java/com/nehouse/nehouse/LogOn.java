package com.nehouse.nehouse;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class LogOn extends Activity {

    private FirebaseAuth mAuth;
    private String userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_on);

        mAuth = FirebaseAuth.getInstance();
    }

    public void LogOnLogOn (View view) {
        String _password = GetPassword();
        String _email = GetEmail();
        String _userName = GetUserName();
        if (_userName.isEmpty() || _password.isEmpty() || _email.isEmpty()) {
            Toast.makeText(LogOn.this, "All fileds are required", Toast.LENGTH_SHORT).show();
        } else if (_password.length() < 6) {
            Toast.makeText(LogOn.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        } else {
            userName = GetUserName();
            email = GetEmail();
            password = GetPassword();
            CreateAccount();
        }
    }

    public String GetUserName(){
        EditText ETusername = (EditText) findViewById(R.id.UserName); //Read info from user interface
        return ETusername.getText().toString();
    }

    public String GetEmail(){
        EditText ETemail = (EditText) findViewById(R.id.Email); //Read info from user interface
        return ETemail.getText().toString();
    }

    public String GetPassword(){
        EditText ETpassword = (EditText) findViewById(R.id.Password1); //Read info from user interface
        return ETpassword.getText().toString();
    }

    public void CreateAccount() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            MainActivity.AUTH = true;
                            Toast.makeText(LogOn.this, "Authentication succesfull.",
                                    Toast.LENGTH_SHORT).show();

                            String userID = user.getUid();

                            HashMap<String, String> user_info = new HashMap<>();
                            user_info.put("id", userID);
                            user_info.put("name", userName);
                            user_info.put("password", password);
                            user_info.put("email", email);

                            MainActivity.usersDB.child(userID).setValue(user_info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LogOn.this, "DB update is succesfull.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LogOn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        MainActivity.currentUser = user;
        if (user != null)
            finish();
    }
}
