package com.nehouse.nehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OperationsHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operations_history);

        LinearLayout OpQueue = (LinearLayout)findViewById(R.id.OperationsQueue);
        TextView comm = (TextView)findViewById(R.id.OpComm);
        TextView own = (TextView)findViewById(R.id.OpOwn);
        TextView sum = (TextView)findViewById(R.id.OpSum);
        for (int i = 0; i < Money.OpCount; i++) {
            LinearLayout Mon = (LinearLayout)findViewById(R.id.Mon);
            comm.setText(Budget.moneyQueue.get(i).comment);
            own.setText(Budget.moneyQueue.get(i).owner);
            if(Budget.moneyQueue.get(i).income) {
                sum.setText(Budget.moneyQueue.get(i).sum);
            }
            else {
                sum.setText("- " + Budget.moneyQueue.get(i).sum);
            }
            OpQueue.addView(Mon);
        }
    }
}
