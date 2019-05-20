package com.nehouse.nehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyWishlist extends AppCompatActivity {
    LinearLayout parent;
    TextView wish;
    ArrayList<String> myWishes;
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wishlist);

        lp.setMargins(25, 5,25,5);
        parent = (LinearLayout)findViewById(R.id.MyWishesQueue);
        if (count != 0) {
            for(int i = 0; i < count; i++) {
                wish = new TextView(MyWishlist.this);
                wish.setText(myWishes.get(i));
                wish.setLayoutParams(lp);
                wish.setBackgroundResource(R.drawable.button_desidn);
                wish.setTextColor(getResources().getColor(R.color.colorWhite));
                wish.setPadding(5, 5, 5, 5);
                //wish.setOnClickListener();
                parent.addView(wish);
            }
        }
    }

    public void addWish(View view) {
        EditText txt = (EditText)findViewById(R.id.newWish);
        String text = txt.getText().toString();
        wish.setText(text);
        wish.setLayoutParams(lp);
        wish.setBackgroundResource(R.drawable.button_desidn);
        wish.setTextColor(getResources().getColor(R.color.colorWhite));
        wish.setPadding(5, 5, 5, 5);
        //wish.setOnClickListener();
        parent.addView(wish);
        myWishes.add(text);
        count++;

    }
}
