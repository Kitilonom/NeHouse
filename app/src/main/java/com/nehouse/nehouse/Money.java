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

    Money(int _sum, String _comm, boolean _inc, String _own) {
        sum = _sum;
        comment = _comm;
        income = _inc;
        owner = findOwner(_own);
        date = new Date();
        Mid = ++MainActivity.opCount + 10000;
    }

    public void ExMoney () {
            MainActivity.moneyQueue.add(this);
            int sum1;
            if (income) {
                sum1 = MainActivity.accQueue.get(owner).accSum + sum;
            }
            else {
                sum1 = MainActivity.accQueue.get(owner).accSum - sum;
            }
            MainActivity.accQueue.get(owner).setAccSum(sum1);
        }

    int findOwner(String own) {
        for(int j = 0; j < MainActivity.accCount; j++) {
            if (MainActivity.accQueue.get(j).accName == own) return j;
        }
        return -1;
    }

}
