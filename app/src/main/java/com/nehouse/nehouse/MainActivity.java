package com.nehouse.nehouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public User MyUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, WelcomePage.class);
        startActivity(intent);
    }

    public void MainActivityCalendar (View view) {
        Intent intent = new Intent(MainActivity.this, Calendar.class);
        startActivity(intent);
    }

    public void MainActivityBudget (View view) {
        Intent intent = new Intent(MainActivity.this, Budget.class);
        startActivity(intent);
    }

    public void MainActivityNotifications (View view) {
        Intent intent = new Intent(MainActivity.this, Notifications.class);
        startActivity(intent);
    }

    public void MainActivityShoppingList (View view) {
        Intent intent = new Intent(MainActivity.this, ShoppingList.class);
        startActivity(intent);
    }

    public void MainActivityContacts (View view) {
        Intent intent = new Intent(MainActivity.this, Contacts.class);
        startActivity(intent);
    }

    public void MainActivityWishlist (View view) {
        Intent intent = new Intent(MainActivity.this, Wishes.class);
        startActivity(intent);
    }

    public void MainActivitySettings (View view) {
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }

}
