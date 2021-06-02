package com.example.mywhatsapp;

public class Message {

    public String userName;
    public String message;
    public String time;

    public Message(String userName, String message,String time) {
        this.userName = userName;
        this.message = message;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
