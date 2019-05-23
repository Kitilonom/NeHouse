package com.nehouse.nehouse.Model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User {
    private static String id;
    private static String name;
    private static String phone;
    private static String email;
    private static String password;
    private static String groupID;
    private static String bday;
    private static String image;

    private User() {
    }

    public User(String _id, String _name, String  _phone, String _email, String _password, String _groupID, String _bday) {
        id = _id;
        name = _name;
        phone = _phone;
        email = _email;
        password = _password;
        groupID = _groupID;
        bday = _bday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGroupID() {
        return groupID;
    }

    public String getBday() {
        return bday;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("name", name);
        result.put("password", password);
        result.put("email", email);
        result.put("phone", phone);
        result.put("groupID", groupID);
        result.put("bday", bday);

        return  result;
    }
}
