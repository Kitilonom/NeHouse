package com.nehouse.nehouse;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Budget extends AppCompatActivity{

    Dialog NewAccountDialog, IncomeDialog, ExpenseDialog;
    public static ArrayList<Money> moneyQueue = new ArrayList<>();
    public static ArrayList<Accounts> accQueue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget);

        LinearLayout AccountsQueue = (LinearLayout)findViewById(R.id.AccountsQueue);
        TextView name = (TextView)findViewById(R.id.AccName);
        TextView sum = (TextView)findViewById(R.id.AccSum);
        for (int i = 0; i < Accounts.accCount; i++) {
            LinearLayout Acc = (LinearLayout)findViewById(R.id.Acc);
            name.setText(Budget.accQueue.get(i).accName);
            sum.setText(Budget.accQueue.get(i).accSum);
            AccountsQueue.addView(Acc);
        }

        NewAccountDialog = new Dialog(Budget.this);
        NewAccountDialog.setContentView(R.layout.new_account);

        IncomeDialog = new Dialog(Budget.this);
        IncomeDialog.setContentView(R.layout.income);

        ExpenseDialog = new Dialog(Budget.this);
        ExpenseDialog.setContentView(R.layout.expense);


  /**    AutoCompleteTextView chooseAcc1 = (AutoCompleteTextView)findViewById(R.id.ExpenseOwner); //установка выпадающего списка
        chooseAcc1.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Accounts.accList));

        AutoCompleteTextView chooseAcc2 = (AutoCompleteTextView)findViewById(R.id.IncomeOwner);
        chooseAcc2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, Accounts.accList));*/
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
        EditText T = (EditText)findViewById(R.id.NewAccountName);
        EditText S = (EditText)findViewById(R.id.NewAccountSum);
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
        new Money(sum, comm, false, own);
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
        new Money(sum, comm, true, own);
        finish();
    }
}
