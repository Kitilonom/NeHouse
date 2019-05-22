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
                wish.setId(i);
                wish.setTextColor(getResources().getColor(R.color.colorWhite));
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
        wish.setId(++MainActivity.count);
        wish.setTextColor(getResources().getColor(R.color.colorWhite));
        wish.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                MainActivity.myWishes.remove(view.getId());
                MainActivity.count--;
                parent.removeView(view);
                return true;
            }});
        parent.addView(wish);
        MainActivity.myWishes.add(text);
        txt.setText(null);
    }
}
