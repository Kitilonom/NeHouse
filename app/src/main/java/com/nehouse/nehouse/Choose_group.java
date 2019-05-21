package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Choose_group extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_group);
    }

    public void NewGroup(View view) {
        Intent intent = new Intent(Choose_group.this, New_Group.class);
        startActivity(intent);
    }

}
