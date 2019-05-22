package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.nehouse.nehouse.Model.Group;

import java.util.HashMap;
import java.util.Map;

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
        String chat = MainActivity.user.getGroupID();

        EditText ETmessage = findViewById(R.id.editText2);
        final String message = ETmessage.getText().toString();

        /**TextView mes = new TextView(Chat.this);
        mes.setText(message);
        mes.setBackgroundResource(R.drawable.button_desidn);
        mes.setLayoutParams(lp);
        mes.setGravity(Gravity.CENTER);
        parent.addView(mes);
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("sender", sender);
        hm.put("receiver", receiver);
        hm.put("message", message );*/

        MainActivity.messagesDB.child(chat).child("sender").setValue(sender).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(Chat.this, "Succesfull1.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        final String key = MainActivity.messagesDB.child(chat).push().getKey();
        Map<String, Object> mes = new HashMap<>();
        mes.put(key, message);
        MainActivity.messagesDB.child(chat).updateChildren(mes).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(Chat.this, "Succesfull2.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ReadMessages(View view) {
        String sender = MainActivity.currentUser.getUid();
        String receiver = MainActivity.group.getName();

        EditText ETmessage = findViewById(R.id.editText2);
        final String message = ETmessage.getText().toString();
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

        MainActivity.messagesDB.child(MainActivity.user.getGroupID()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { //очишение всей ленты
               // MainActivity.message = dataSnapshot.getValue(Message.class);
               // if() {}
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}