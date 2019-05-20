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
import com.nehouse.nehouse.Model.User;

    public class MainActivity extends AppCompatActivity {

        private FirebaseUser firebaseUser; //выход из профиля
        private DatabaseReference refUser;
        private DatabaseReference refChats;

        ImageView profile_image; //заполнить все поля  всех окон!!!!!где указываетс что-то о пользователе

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Intent intent = new Intent(MainActivity.this, com.nehouse.nehouse.WelcomePage.class);
            startActivity(intent);

            Dialog gDialog = new Dialog(MainActivity.this);
            gDialog.setContentView(R.layout.choose_group);
            gDialog.show();

            firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            if(firebaseUser != null) {
                refUser = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
                refChats = FirebaseDatabase.getInstance().getReference("Chats");

                refUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
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


                refChats.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
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
            Intent intent = new Intent(MainActivity.this, Wishes.class);
            startActivity(intent);
        }

        public void MainActivitySettings (View view) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        }

        public void NewGroup(View view) {
            Dialog nGroup = new Dialog(MainActivity.this);
            nGroup.setContentView(R.layout.new_group);
            nGroup.show();
        }

        public void NewGroupConfirm(View view) {
            finish();
        }

    }
