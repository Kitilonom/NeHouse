package com.nehouse.nehouse;


import java.util.ArrayList;

public class Accounts {
    public static int accCount = 0;
    public  static ArrayList<String> accList = new ArrayList<>();
    int accSum;
    int accID;
    String accName;

    Accounts(int sum, String name) {
        accSum = sum;
        accName = name;
        accID = ++accCount + 20000;
        accList.add(name);
        Budget.accQueue.add(this);
    }

    void setAccSum (int _sum) {
        this.accSum = _sum;
    }

}
