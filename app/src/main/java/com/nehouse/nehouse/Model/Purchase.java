package com.nehouse.nehouse.Model;

import com.nehouse.nehouse.MainActivity;

public class Purchase {
    int sum;
    String title;

    public Purchase (int _sum, String _title) {
        sum = _sum;
        title = _title;
        MainActivity.purchaseQueue.add(this);
        MainActivity.purCount++;
    }
}
