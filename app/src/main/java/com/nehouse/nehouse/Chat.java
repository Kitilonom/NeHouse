package com.nehouse.nehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class Chat extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance(); //ссылка на БД
    private DatabaseReference myRef = database.getReference("message"); //Блок в БД в котором хранятся сообщения
    Button message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        message = findViewById(R.id.Send);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("Hello, World!");
                Toast t = Toast.makeText(getApplicationContext(),"SEND", Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
