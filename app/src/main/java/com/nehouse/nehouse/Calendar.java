package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calendar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        Button Event1 = (Button)this.findViewById(R.id.event1);
        Button Event2 = (Button)this.findViewById(R.id.event2);
        Button Event3 = (Button)this.findViewById(R.id.event3);

        Event1.setText("Дата" + ": " + "Название1"); //будет класс, который всю эту дрянь хранит
        Event2.setText("Дата" + ": " + "Название2");
        Event3.setText("Дата" + ": " + "Название3");
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