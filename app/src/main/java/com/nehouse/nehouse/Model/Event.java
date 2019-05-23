package com.nehouse.nehouse.Model;

import com.nehouse.nehouse.MainActivity;

import java.util.Date;

public class Event {
    public String date;
    String comment;
    public String eventType;
    String purchase;
    int sum;

    public  Event(String _date, String _comm, String _et, String _purchase, int _sum) {
        date = _date;
        comment = _comm;
        eventType = _et;
        purchase = _purchase;
        sum = _sum;
        MainActivity.evCount++;
        MainActivity.eventQueue.add(this);
    }
}
