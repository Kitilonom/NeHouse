package com.nehouse.nehouse.Model;

import java.util.ArrayList;

public class Message {
    private ArrayList<String> mesList;
    private String chat;

    public Message() {
    }

    public String getChat() {
        return chat;
    }

    public ArrayList<String> getMeslist() {
        return mesList;
    }

    public  Message(ArrayList<String> list, String _chat){
        mesList = list;
        chat = _chat;
    }

    public void setMessage(String mes){
        mesList.add(mes);
    }
}




