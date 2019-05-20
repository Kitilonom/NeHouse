package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Wishes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishes);
    }

    public void MyWishlist(View view) {
        Intent intent = new Intent(Wishes.this, MyWishlist.class);
        startActivity(intent);
    }
}
