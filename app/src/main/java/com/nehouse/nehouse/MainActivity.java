package com.nehouse.nehouse;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nehouse.nehouse.Model.Event;
import com.nehouse.nehouse.Model.Purchase;
import com.nehouse.nehouse.Model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    public static DatabaseReference usersDB = FirebaseDatabase.getInstance().getReference("Users");
    public static DatabaseReference chatsDB = FirebaseDatabase.getInstance().getReference("Chats");
    public static User user;
    public static boolean AUTH = false;


        Dialog gDialog, nGroup;
        public static ArrayList<String> myWishes;
        public static int count, evCount, accCount, opCount, purCount;
        public static ArrayList<Event> eventQueue;
        public static  ArrayList<Purchase> purchaseQueue;
        public static  ArrayList<Money> moneyQueue;
        public static ArrayList<Accounts> accQueue;
        public  static ArrayList<String> accList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            count = 0;
            evCount = 0;
            accCount = 0;
            opCount = 0;
            purCount = 0;

            if (!AUTH) {
                Intent intent = new Intent(MainActivity.this, com.nehouse.nehouse.WelcomePage.class);
                startActivity(intent);
            }

            gDialog = new Dialog(MainActivity.this);
            gDialog.setContentView(R.layout.choose_group);
            gDialog.show();

            accList = new ArrayList<>();
            eventQueue = new ArrayList<>();
            purchaseQueue = new ArrayList<>();
            moneyQueue = new ArrayList<>();
            accQueue = new ArrayList<>();
            myWishes = new ArrayList<>();


//            accQueue.add(new Accounts(1000, "long"));
//            accCount++;
//            accList.add("long");


         
                usersDB.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        user = dataSnapshot.getValue(User.class);
                        /**if (user.getImage().equals("default")) {
                            profile_image.setImageResource(R.mipmap.ic_launcher); //можно заменить человечком
                        } else {
                            Glide.with(MainActivity.this).load(user.getImage()).into(profile_image);
                        }*/
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });


                chatsDB.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
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
            Intent intent = new Intent(MainActivity.this, Chat.class);
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
            Intent intent = new Intent(MainActivity.this, MyWishlist.class);
            startActivity(intent);
        }

        public void MainActivitySettings (View view) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        }

        public void NewGroup(View view) {
            nGroup = new Dialog(MainActivity.this);
            nGroup.setContentView(R.layout.new_group);
            nGroup.show();
        }

        public void NewGroupConfirm(View view) {
            gDialog.dismiss();
            nGroup.dismiss();
        }

    }
