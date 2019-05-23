package com.nehouse.nehouse;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatViewInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

import static com.nehouse.nehouse.MainActivity.groupDB;
import static com.nehouse.nehouse.MainActivity.user;

public class New_Group extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_group);
    }

    public void NewGroupConfirm(View view) {
        EditText ETname = (EditText) findViewById(R.id.NewGroupName);
        String Aname =  ETname.getText().toString();

        ArrayList<String> list = new ArrayList<>();
        list.add(user.getId());

        HashMap<String, Object> group_info = new HashMap<>();
        group_info.put("name", Aname);
        group_info.put("count", 1);
        group_info.put ("list", list);

        groupDB.child(Aname).setValue(group_info).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(New_Group.this, "DB update new group is succesfull.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
