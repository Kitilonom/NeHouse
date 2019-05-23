package com.nehouse.nehouse.Model;

public class MyChat {
    private String sender;
    private String message;

    public MyChat(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public MyChat() {}

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
