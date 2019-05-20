package com.nehouse.nehouse.Model;

import com.google.firebase.database.IgnoreExtraProperties;

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

    public User(String _id, String _name, String  _phone, String _email, String _password, String _groupID, String _bday, String _image) {
        id = _id;
        name = _name;
        phone = _phone;
        email = _email;
        password = _password;
        groupID = _groupID;
        bday = _bday;
        image = _image;
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

    public String getImage() {
        return image;
    }





}
