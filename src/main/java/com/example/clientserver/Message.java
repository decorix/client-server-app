package com.example.clientserver;

import com.mysql.cj.conf.IntegerProperty;

public class Message {
    private  int MESSAGE_ID;
    private String USER_NAME;
    private String USER_PATRONYMIC;
    private String USER_SECONDNAME;
    private String USER_ITEM;
    private String USER_DATE;
    private String USER_MESSAGE;
    private String USER_NICKNAME;

    public Message(int MESSAGE_ID, String USER_NAME, String USER_PATRONYMIC, String USER_SECONDNAME, String USER_ITEM, String USER_DATE, String USER_MESSAGE) {
        this.MESSAGE_ID = MESSAGE_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PATRONYMIC = USER_PATRONYMIC;
        this.USER_SECONDNAME = USER_SECONDNAME;
        this.USER_ITEM = USER_ITEM;
        this.USER_DATE = USER_DATE;
        this.USER_MESSAGE = USER_MESSAGE;
    }
    public Message(String USER_NAME, String USER_PATRONYMIC, String USER_SECONDNAME, String USER_ITEM, String USER_DATE, String USER_MESSAGE, String USER_NICKNAME) {
        this.USER_NAME = USER_NAME;
        this.USER_PATRONYMIC = USER_PATRONYMIC;
        this.USER_SECONDNAME = USER_SECONDNAME;
        this.USER_ITEM = USER_ITEM;
        this.USER_DATE = USER_DATE;
        this.USER_MESSAGE = USER_MESSAGE;
        this.USER_NICKNAME = USER_NICKNAME;
    }

    public Message() {

    }

    public int getMESSAGE_ID() {
        return MESSAGE_ID;
    }

    public void setMESSAGE_ID(int MESSAGE_ID) {
        this.MESSAGE_ID = MESSAGE_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PATRONYMIC() {
        return USER_PATRONYMIC;
    }

    public void setUSER_PATRONYMIC(String USER_PATRONYMIC) {
        this.USER_PATRONYMIC = USER_PATRONYMIC;
    }

    public String getUSER_SECONDNAME() {
        return USER_SECONDNAME;
    }

    public void setUSER_SECONDNAME(String USER_SECONDNAME) {
        this.USER_SECONDNAME = USER_SECONDNAME;
    }

    public String getUSER_ITEM() {
        return USER_ITEM;
    }

    public void setUSER_ITEM(String USER_ITEM) {
        this.USER_ITEM = USER_ITEM;
    }

    public String getUSER_DATE() {
        return USER_DATE;
    }

    public void setUSER_DATE(String USER_DATE) {
        this.USER_DATE = USER_DATE;
    }

    public String getUSER_MESSAGE() {
        return USER_MESSAGE;
    }

    public void setUSER_MESSAGE(String USER_MESSAGE) {
        this.USER_MESSAGE = USER_MESSAGE;
    }

    public String getUSER_NICKNAME() {
        return USER_NICKNAME;
    }

    public void setUSER_NICKNAME(String USER_NICKNAME) {
        this.USER_NICKNAME = USER_NICKNAME;
    }
}
