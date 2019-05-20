package com.nehouse.nehouse.Model;

import java.util.Date;

public class Event {
    Date date;
    String title;
    String comment;
    String eventType;
    String purchase;
    int sum;

    public  Event(Date _date, String _title, String _comm, String _et, String _purchase, int _sum) {
        date = _date;
        title = _title;
        comment = _comm;
        eventType = _et;
        purchase = _purchase;
        sum = _sum;
    }
}
