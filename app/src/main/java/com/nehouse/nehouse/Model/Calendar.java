package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import static java.lang.Math.min;

public class Calendar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        LinearLayout parent = findViewById(R.id.evQ);


        for (int i = 0; i < min(MainActivity.evCount, 3); i++) {
            Button Event1 = new Button(Calendar.this);
            Event1.setBackgroundResource(R.drawable.button_desidn);
            Event1.setTextColor(getResources().getColor(R.color.colorWhite));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
            lp.setMargins(50, 30, 50, 0);
            Event1.setLayoutParams(lp);
            Event1.setId(500000 + i);
            Event1.setText(MainActivity.eventQueue.get(i).date + System.getProperty("line.separator") + MainActivity.eventQueue.get(i).eventType);
            parent.addView(Event1);
        }
    }

    public void CalendarDate(View view) {
        Intent intent = new Intent(Calendar.this, DateEvents.class);
        startActivity(intent);
    }

    public void CalendarNewEvent(View view) {
        Intent intent = new Intent(Calendar.this, EditEvent.class);
        startActivity(intent);
    }

}