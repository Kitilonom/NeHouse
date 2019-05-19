package com.nehouse.nehouse;

public class User {
    private static String accID;
    private static String accFN;
    private static String accLN;
    private static long accPhone;
    private static String accEmail;
    private static String accPassword;
    private static String groupID;
    private static long accBday;

    public User() {
    }

    public User(String email, String password, String id) {
        accEmail = email;
        accPassword = password;
        accID = id;
    }

    public String getAccID() {
        return accID;
    }

    public String getAccFN() {
        return accFN;
    }

    public String getAccLN() {
        return accLN;
    }

    public long getAccPhone() {
        return accPhone;
    }

    public String getAccEmail() {
        return accEmail;
    }

    public String getAccPassword() {
        return accPassword;
    }

    public String getGroupID() {
        return groupID;
    }

    public long gerAccBday() {
        return accBday;
    }

    public void setAccID(String id) {
        accID = id;
    }

    public void setAccFN(String fn) {
        accFN = fn;
    }

    public void setAccLN(String ln) {
        accLN = ln;
    }

    public void setAccPhone(long phone) {
        accPhone = phone;
    }

    public void setAccEmail(String email) {
        accEmail = email;
    }

    public void setAccPassword(String password) {
        accPassword = password;
    }

    public void setAccBday(long bday) {
        accBday = bday;
    }

    public void setGroupID(String id) {
        groupID = id;
    }
}
