package com.example.clientserver;

public class User {
    private String USER_EMAIL;
    private String USER_PASSWORD;
    private String USER_NICKNAME;
    private String USER_GROUPNUMBER;
    private String USER_PASSWORDAGAIN;
    private String USER_STATUS;

    public User(String USER_EMAIL, String USER_NICKNAME, String USER_GROUPNUMBER, String USER_PASSWORD, String USER_PASSWORDAGAIN, String USER_STATUS) {
        this.USER_EMAIL = USER_EMAIL;
        this.USER_NICKNAME = USER_NICKNAME;
        this.USER_GROUPNUMBER = USER_GROUPNUMBER;
        this.USER_PASSWORD = USER_PASSWORD;
        this.USER_PASSWORDAGAIN = USER_PASSWORDAGAIN;
        this.USER_STATUS = USER_STATUS;
    }

    public User() {

    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_NICKNAME() {
        return USER_NICKNAME;
    }

    public void setUSER_NICKNAME(String USER_NICAKNAME) {
        this.USER_NICKNAME = USER_NICAKNAME;
    }

    public String getUSER_GROUPNUMBER() {
        return USER_GROUPNUMBER;
    }

    public void setUSER_GROUPNUMBER(String USER_GROUPNUMBER) {
        this.USER_GROUPNUMBER = USER_GROUPNUMBER;
    }

    public String getUSER_PASSWORDAGAIN() {
        return USER_PASSWORDAGAIN;
    }

    public void setUSER_PASSWORDAGAIN(String USER_PASSWORDAGAIN) {
        this.USER_PASSWORDAGAIN = USER_PASSWORDAGAIN;
    }

    public String getUSER_STATUS() {
        return USER_STATUS;
    }

    public void setUSER_STATUS(String USER_STATUS) {
        this.USER_STATUS = USER_STATUS;
    }

}
