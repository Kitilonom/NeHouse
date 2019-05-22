package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nehouse.nehouse.Model.Messages;
import com.nehouse.nehouse.Model.User;

import java.util.Date;
import java.util.HashMap;

public class Chat extends AppCompatActivity {
    LinearLayout parent;
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,Gravity.CENTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (MainActivity.user.getGroupID() == null) {
            Intent intent = new Intent(Chat.this, ChooseGroup.class);
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);


            lp.setMargins(25, 5,25,5);
            parent = (LinearLayout)findViewById(R.id.MessageQueue);

           /** MainActivity.messagesDB.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull0 DataSnapshot dataSnapshot) {
                    MainActivity.message = dataSnapshot.getValue(Messages.class);
                    TextView mes = new TextView(Chat.this);
                    int size = MainActivity.message.getMeslist().size();
                    mes.setText(MainActivity.message.getMeslist().get(size - 1));
                    mes.setBackgroundResource(R.drawable.button_desidn);
                    mes.setLayoutParams(lp);
                    mes.setGravity(Gravity.CENTER);
                    parent.addView(mes);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });*/
        }

    public void ChatSend(View view) {
        String sender = MainActivity.currentUser.getUid();
        String receiver = MainActivity.group.getName();

        EditText ETmessage = findViewById(R.id.editText2);
        String message = ETmessage.getText().toString();
        TextView mes = new TextView(Chat.this);
        mes.setText(message);
        mes.setBackgroundResource(R.drawable.button_desidn);
        mes.setLayoutParams(lp);
        mes.setGravity(Gravity.CENTER);
        parent.addView(mes);

        HashMap<String, Object> hm = new HashMap<>();
        hm.put("sender", sender);
        hm.put("receiver", receiver);
        hm.put("message", message );

        MainActivity.messagesDB.child("receiver").push().setValue(hm);
    }

}