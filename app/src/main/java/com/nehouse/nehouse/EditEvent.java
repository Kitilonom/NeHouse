package com.nehouse.nehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nehouse.nehouse.Model.Event;
import com.nehouse.nehouse.Model.Purchase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_event);
    }

    public void newEvent(View view) {
        EditText ETdate = findViewById(R.id.EventDate);
        String date = ETdate.getText().toString();
        EditText ETtype = findViewById(R.id.EventType);
        EditText ETcomm = findViewById(R.id.EventComment);
        EditText ETpur = findViewById(R.id.EventPresent);
        EditText ETcost = findViewById(R.id.EventCost);

        String type = ETtype.getText().toString();
        String comm = ETcomm.getText().toString();
        String pur = ETpur.getText().toString();
        int cost = Integer.parseInt(ETcost.getText().toString());

        MainActivity.eventQueue.add(new Event(date, comm, type, pur, cost));
        MainActivity.evCount++;

        MainActivity.purchaseQueue.add(new Purchase(cost, pur));
        MainActivity.purCount++;

    }
}
