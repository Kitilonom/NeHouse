package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.nehouse.nehouse.Model.MyChat;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
    ArrayList<Chat> mchat; // список всех сообщений.

   // LinearLayout parent;
   // LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,Gravity.CENTER);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (MainActivity.user.getGroupID() == null) {
            Intent intent = new Intent(Chat.this, ChooseGroup.class);
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        String group = MainActivity.user.getGroupID();
        MainActivity.messagesDB.child(group).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                readMesagges();
                //Тут реализовать вывод на экран всех сообщений из списка mchat
                //Перед выводом сообщений нужно удалить все сообщения что есть на экране и потом заново создать все полученные
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });


           /** lp.setMargins(25, 5,25,5);
            parent = (LinearLayout)findViewById(R.id.MessageQueue);

           MainActivity.messagesDB.addValueEventListener(new ValueEventListener() {
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
        EditText ETmessage = findViewById(R.id.editText2);
        final String message = ETmessage.getText().toString();
        String groupID = MainActivity.user.getGroupID();

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

        MyChat ch = new MyChat(sender, message);
        String key = MainActivity.messagesDB.child(groupID).push().getKey();
        MainActivity.messagesDB.child(groupID).child(key).setValue(ch).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(Chat.this, "Send",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void readMesagges() {
        String groupID = MainActivity.user.getGroupID();
        mchat = new ArrayList<>();

        MainActivity.messagesDB.child(groupID).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mchat.clear();
                Chat chat = dataSnapshot.getValue(Chat.class);
                mchat.add(chat);
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
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
