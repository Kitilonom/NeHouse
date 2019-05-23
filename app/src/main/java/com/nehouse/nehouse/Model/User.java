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
    private static String groupID;
    private static String bday;

    public User() {
    }

    public User(String _id, String _name, String  _phone, String _email, String _groupID, String _bday) {
        id = _id;
        name = _name;
        phone = _phone;
        email = _email;
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
        result.put("email", email);
        result.put("phone", phone);
        result.put("groupID", groupID);
        result.put("bday", bday);

        return  result;
    }

    public User(String _email, String _id) {
        email= _email;
        id = _id;
    }

    public void setGroupID(String key) {
        groupID = key;
    }
    public void setId(String key) {
        id = key;
    }
    public void setPhone(String key) {
        phone = key;
    }
    public void setEmail(String key) {
        email = key;
    }
    public void setName(String key) {
        name = key;
    }
    public void setBday(String key) {
        bday = key;
    }

}
