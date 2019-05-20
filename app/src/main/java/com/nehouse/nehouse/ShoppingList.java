package com.nehouse.nehouse;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ShoppingList extends AppCompatActivity {

    Dialog NewPurchaseDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);

        NewPurchaseDialog = new Dialog(ShoppingList.this);
        NewPurchaseDialog.setContentView(R.layout.new_purchase);
    }

    public void NewPurchase(View view) {
        NewPurchaseDialog.show();
    }

    public void NewPurchaseConfirm (View view) {
        EditText ETsum = (EditText)findViewById(R.id.NewPurchaseSum);
        EditText ETtitle = (EditText)findViewById(R.id.NewPurchaseName);
        String Sum = ETsum.getText().toString();
        int sum = Integer.parseInt(Sum);
        String title = ETtitle.getText().toString();
        new Money(sum, title, false, "none");
        finish();
    }
}
