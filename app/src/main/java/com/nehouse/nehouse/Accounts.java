package com.nehouse.nehouse;


import java.util.ArrayList;

public class Accounts {
    int accSum;
    int accID;
    String accName;

    Accounts(int sum, String name) {
        accSum = sum;
        accName = name;
        accID = ++MainActivity.accCount + 20000;
        MainActivity.accList.add(name);
        MainActivity.accQueue.add(this);
    }

    void setAccSum (int _sum) {
        this.accSum = _sum;
    }

}




