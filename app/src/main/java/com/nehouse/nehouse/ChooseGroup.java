package com.nehouse.nehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.nehouse.nehouse.Model.Group;
import com.nehouse.nehouse.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChooseGroup extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_group);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (MainActivity.user.getGroupID() != null) {
            Intent intent = new Intent(ChooseGroup.this, Chat.class);
            startActivity(intent);
        }
    }

    public void NewGroup(View view) {
        Intent intent = new Intent(ChooseGroup.this, NewGroup.class);
        startActivity(intent);
    }

    public void ChoosenGroup(View view) {
        EditText ETname = (EditText) findViewById(R.id.ChooseGroup);
        final String name =  ETname.getText().toString();


        
        MainActivity.groupDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(name).exists()) {
                    MainActivity.user.setGroupID(name);
                    final DataSnapshot ds = dataSnapshot;
                    final String key = MainActivity.groupDB.child(name).push().getKey();
                    Map<String, Object> info = new HashMap<>();
                    info.put(key, MainActivity.currentUser.getUid());
                    MainActivity.groupDB.child(name).updateChildren(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            MainActivity.group = ds.getValue(Group.class);
                            Intent intent = new Intent(ChooseGroup.this, Chat.class);
                            Toast.makeText(ChooseGroup.this, "Succesfull.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(ChooseGroup.this, "This group isn't exists.",
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

