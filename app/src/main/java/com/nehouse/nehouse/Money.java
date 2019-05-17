package com.nehouse.nehouse;

import java.util.Date;

public class Money {
    static int OpCount;
    int sum;
    Date date;
    int Mid;
    boolean income;
    String comment;
    int owner;

    Money() {
        sum = 0;
        comment = null;
        income = false;
        owner = -1;
        date = new Date();
        Mid = ++OpCount + 10000;
    }

    Money(int _sum, String _comm, boolean _inc, String _own) {
        sum = _sum;
        comment = _comm;
        income = _inc;
        owner = findOwner(_own);
        date = new Date();
        Mid = ++OpCount + 10000;
        Budget.moneyQueue.add(this);
    }

    int findOwner(String own) {
        for(int j = 0; j < accCount; j++) {
            if (accQueue[j] == own) return j;
        }
        return -1;
    }

}
