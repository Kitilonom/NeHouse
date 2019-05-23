package com.nehouse.nehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nehouse.nehouse.Model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.nehouse.nehouse.MainActivity.user;

public class NewGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_group);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (MainActivity.user.getGroupID() != null) {
            Intent intent = new Intent(NewGroup.this, Chat.class);
            startActivity(intent);
        }
    }

    public void NewGroupONConfirm(View view) {
        EditText ETname = findViewById(R.id.TVNewGroupName);
        final String name = ETname.getText().toString();
        if (name.equals(null)) {
            Toast.makeText(NewGroup.this, "Filed is required", Toast.LENGTH_SHORT).show();
        } else {
        MainActivity.groupDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(name).exists()) {
                    Toast.makeText(NewGroup.this, "This group is already exists.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.user.setGroupID(name);
                    String userId = MainActivity.user.getId();

                    HashMap<String, String> hm = new HashMap<>();
                    hm.put("groupID", name);
                    MainActivity.groupDB.child(userId).setValue(hm);

                    final DataSnapshot ds = dataSnapshot;
                    final String key = MainActivity.groupDB.child("friends").push().getKey();
                    Map<String, Object> info = new HashMap<>();
                    info.put(key, userId);
                    MainActivity.groupDB.child(name).updateChildren(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            MainActivity.group = ds.getValue(Group.class);
                            Intent intent = new Intent(NewGroup.this, Chat.class);
                            Toast.makeText(NewGroup.this, "Succesfull.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
    });
        }
    }
}

