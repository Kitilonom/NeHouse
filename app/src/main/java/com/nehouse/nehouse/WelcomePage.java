package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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

import static android.content.ContentValues.TAG;

public class WelcomePage extends Activity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void WelcomePageLogIn (View view) {
        String _password = GetPassword();
        String _email = GetEmail();
        if (_password.isEmpty() || _email.isEmpty()) {
            Toast.makeText(WelcomePage.this, "All fileds are required", Toast.LENGTH_SHORT).show();
        } else {
            email = _email;
            password = _password;
            SignIn();
        }
    }

    public String GetEmail(){
        EditText ETemail = (EditText) findViewById(R.id.Email);
        return ETemail.getText().toString();
    }

    public String GetPassword(){
        EditText ETpassword = (EditText) findViewById(R.id.Password);
        return ETpassword.getText().toString();
    }

    public void SignIn()
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(WelcomePage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }


    public void WelcomePageLogOn (View view) {
        Intent intent = new Intent(WelcomePage.this, LogOn.class);
        startActivity(intent);
    }

    public void WelcomePageForgot (View view) {
        Intent intent = new Intent(WelcomePage.this, ForgotPassword.class);
        startActivity(intent);
    }

    private void updateUI(FirebaseUser user) {
        currentUser = user;
        if (user != null) {
            Intent intent = new Intent(WelcomePage.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
