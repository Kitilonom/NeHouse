package com.nehouse.nehouse;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class Budget extends AppCompatActivity{

    Dialog NewAccountDialog, IncomeDialog, ExpenseDialog;
    public static ArrayList<Money> moneyQueue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget);
        NewAccountDialog = new Dialog(Budget.this);
        NewAccountDialog.setContentView(R.layout.new_account);
        IncomeDialog = new Dialog(Budget.this);
        IncomeDialog.setContentView(R.layout.income);
        ExpenseDialog = new Dialog(Budget.this);
        ExpenseDialog.setContentView(R.layout.expense);
        moneyQueue = new ArrayList<>();
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
}
