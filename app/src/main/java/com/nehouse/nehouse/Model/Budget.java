package com.nehouse.nehouse;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Budget extends AppCompatActivity{

    Dialog NewAccountDialog, IncomeDialog, ExpenseDialog;
    LinearLayout parent;
    View promptsView;
    EditText T, S;
    LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100, Gravity.CENTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LayoutInflater li = LayoutInflater.from(this);
        promptsView = li.inflate(R.layout.new_account, null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget);
        parent = findViewById(R.id.AccountsQueue);
        LinearLayout Acc = new LinearLayout(Budget.this);
        TextView name = new TextView(Budget.this);
        TextView sum = new TextView(Budget.this);

        if (MainActivity.accCount != 0) {
        for (int i = 0; i < MainActivity.accCount; i++) {
            Acc.setLayoutParams(lp1);
            Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(1000);
            Acc.setBackgroundResource(R.drawable.button_desidn);
            name.setText(MainActivity.accQueue.get(i).accName);
            sum.setText(MainActivity.accQueue.get(i).accSum);
            sum.setTextColor(getResources().getColor(R.color.colorWhite));
            name.setTextColor(getResources().getColor(R.color.colorWhite));
            name.setTextSize(30);
            sum.setTextSize(40);
            parent.addView(Acc);
            Acc.addView(name);
            Acc.addView(sum);
        }}

        NewAccountDialog = new Dialog(Budget.this);
        NewAccountDialog.setContentView(R.layout.new_account);

        IncomeDialog = new Dialog(Budget.this);
        IncomeDialog.setContentView(R.layout.income);

        ExpenseDialog = new Dialog(Budget.this);
        ExpenseDialog.setContentView(R.layout.expense);


//        AutoCompleteTextView chooseAcc1 = (AutoCompleteTextView)findViewById(R.id.ExpenseOwner); //установка выпадающего списка
//       if (MainActivity.accCount != 0) {chooseAcc1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, MainActivity.accList));}
//
//        AutoCompleteTextView chooseAcc2 = (AutoCompleteTextView)findViewById(R.id.IncomeOwner);
//        if (MainActivity.accCount != 0) {chooseAcc2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, MainActivity.accList));}
    }

   public void BudgetNewAccount (View view) {
        NewAccountDialog.show();
    }

    public void BudgetIncome (View view) {
        IncomeDialog.show();
    }

    public void BudgetExpense (View view) {
        ExpenseDialog.show();
    }

    public void BudgetOperationsHistory (View view) {
        Intent intent = new Intent(Budget.this, OperationsHistory.class);
        startActivity(intent);
    }

    public void BudgetAccount (View view) {
        //нажатие на счет
    }


    public void NewAccount (View view) {

        T = promptsView.findViewById(R.id.NewAccountName);
        S = promptsView.findViewById(R.id.NewAccountSum);
        int sum = Integer.parseInt(S.getText().toString());
        String name = T.getText().toString();
        new Accounts(sum, name);

    }

    public void ExpenseConfirm (View view) {
        EditText ETsum = (EditText)findViewById(R.id.ExpenseSum);
        EditText ETcomm = (EditText)findViewById(R.id.ExpenseComment);
        EditText ETown = (EditText)findViewById(R.id.ExpenseOwner);
        String Sum = ETsum.getText().toString();
        int sum = Integer.parseInt(Sum);
        String comm = ETcomm.getText().toString();
        String own = ETown.getText().toString();
        Money m = new Money(sum, comm, false, own);
        m.ExMoney();
        finish();
    }

    public void IncomeConfirm (View view) {
        EditText ETsum = (EditText)findViewById(R.id.ExpenseSum);
        EditText ETcomm = (EditText)findViewById(R.id.ExpenseComment);
        EditText ETown = (EditText)findViewById(R.id.ExpenseOwner);
        String Sum = ETsum.getText().toString();
        int sum = Integer.parseInt(Sum);
        String comm = ETcomm.getText().toString();
        String own = ETown.getText().toString();
        Money m = new Money(sum, comm, true, own);
        m.ExMoney();
        finish();
    }
}
