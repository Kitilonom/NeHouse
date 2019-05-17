package com.nehouse.nehouse;

import java.util.Date;

public class Money {
    static int OpCount = 0;
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
        int sum1;
        if (income) {
            sum1 = Budget.accQueue.get(owner).accSum + sum;
        }
        else {
            sum1 = Budget.accQueue.get(owner).accSum - sum;
        }
        Budget.accQueue.get(owner).setAccSum(sum1);
    }

    int findOwner(String own) {
        for(int j = 0; j < Accounts.accCount; j++) {
            if (Budget.accQueue.get(j).accName == own) return j;
        }
        return -1;
    }

}
