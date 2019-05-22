package com.nehouse.nehouse.Model;

import java.util.ArrayList;

public class Messages {
    private ArrayList<String> mesList;
    private String chat;

    public Messages() {
    }

    public String getChat() {
        return chat;
    }

    public ArrayList<String> getMeslist() {
        return mesList;
    }

    public  Messages(ArrayList<String> list, String _chat){
        mesList = list;
        chat = _chat;
    }
}




