package com.nehouse.nehouse;

import android.media.AudioManager;
import android.media.ToneGenerator;
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
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 70, Gravity.CENTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wishlist);


        lp.setMargins(25, 10,25,0);
        parent = (LinearLayout)findViewById(R.id.MyWishesQueue);
        if (MainActivity.count != 0) {
            for(int i = 0; i < MainActivity.count; i++) {
                TextView wish = new TextView(MyWishlist.this);
                wish.setText(MainActivity.myWishes.get(i));
                wish.setBackgroundResource(R.drawable.button_desidn);
                wish.setLayoutParams(lp);
                wish.setTextColor(0);
                wish.setGravity(Gravity.CENTER);
                parent.addView(wish);
            }
        }
    }

    public void addWish(View view) {
        EditText txt = (EditText)findViewById(R.id.newWish);
        String text = txt.getText().toString();
        TextView wish = new TextView(MyWishlist.this);
        wish.setText(text);
        wish.setBackgroundResource(R.drawable.button_desidn);
        wish.setLayoutParams(lp);
        wish.setGravity(Gravity.CENTER);
        wish.setTextColor(0);
        parent.addView(wish);
        MainActivity.myWishes.add(text);
        txt.setText(null);
        MainActivity.count++;
    }

//    public void addWish(View view) {
//        EditText txt = (EditText)findViewById(R.id.newWish);
//        String text = txt.getText().toString();
//        TextView wish2 = new TextView(MyWishlist.this);
//
//        wish2.setText(text);
//        wish2.setLayoutParams(lp);
//        wish2.setBackgroundResource(R.drawable.button_desidn);
//        wish2.setTextColor(getResources().getColor(R.color.colorWhite));
//        wish2.setPadding(5, 5, 5, 5);
//        parent.addView(wish2);
//        myWishes.add(text);
//        count++;
//    }
}
