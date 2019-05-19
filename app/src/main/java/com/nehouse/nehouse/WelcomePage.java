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


/**
 * Created by TotallySpies on 01.05.2019
 */

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
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void WelcomePageLogIn (View view) {
        String _password = GetPassword();
        String _email = GetEmail();
        if (_password.isEmpty() || _email.isEmpty()) {
            Toast.makeText(WelcomePage.this, "All fileds are required", Toast.LENGTH_SHORT).show();
        } else {
            email = GetEmail();
            password = GetPassword();
            SignIn();
        }
    }

    public String GetEmail(){
        EditText ETemail = (EditText) findViewById(R.id.Email); //Read info from user interface
        return ETemail.getText().toString();
    }

    public String GetPassword(){
        EditText ETpassword = (EditText) findViewById(R.id.Password); //Read info from user interface
        return ETpassword.getText().toString();
    }

    public void SignIn()
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(WelcomePage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

   /** public void getCurrentUser() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            String uid = user.getUid();
        }
    }*/


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
        if (user != null)
            finish();
    }
}
