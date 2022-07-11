package com.example.clientserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {
        if (user.getUSER_PASSWORD().equals(user.getUSER_PASSWORDAGAIN())) {
            String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_EMAIL + "," + Const.USER_PASSWORD + "," +
                    Const.USER_NICKNAME + "," + Const.USER_GROUPNUMBER + "," + Const.USER_STATUS + ")" + " VALUES" + "(?,?,?,?,?)";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);

                prSt.setString(1, user.getUSER_EMAIL());
                prSt.setString(2, user.getUSER_PASSWORD());
                prSt.setString(3, user.getUSER_NICKNAME());
                prSt.setString(4, user.getUSER_GROUPNUMBER());
                prSt.setString(5, user.getUSER_STATUS());

                prSt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Passwords don't match");
        }
    }




    public ResultSet getUser(User user){
        ResultSet resSet =  null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=? AND " + Const.USER_STATUS + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, user.getUSER_EMAIL());
            prSt.setString(2, user.getUSER_PASSWORD());
            prSt.setString(3, user.getUSER_STATUS());

            resSet = prSt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getNews(Message message){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE2;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;

    }

    public void addMessageDB(Message message){
            String insert = "INSERT INTO " + Const.USER_TABLE2 + "(" + Const.USER_NAME + "," + Const.USER_PATRONYMIC + "," +
                    Const.USER_SECONDNAME + "," + Const.USER_ITEM+ "," + Const.USER_DATE + "," + Const.USER_MESSAGE + ")" + " VALUES" + "(?,?,?,?,?,?)";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);

                prSt.setString(1, message.getUSER_NAME());
                prSt.setString(2, message.getUSER_PATRONYMIC());
                prSt.setString(3, message.getUSER_SECONDNAME());
                prSt.setString(4, message.getUSER_ITEM());
                prSt.setString(5, message.getUSER_DATE());
                prSt.setString(6, message.getUSER_MESSAGE());
               // prSt.setString(7, user.getUSER_STATUS());

                prSt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }



}

/*
+ " WHERE " + Const.MESSAGE_ID + "=? AND " +
                Const.USER_NAME + "=? AND " + Const.USER_PATRONYMIC + "=? AND " + Const.USER_SECONDNAME + "=? AND " +
                Const.USER_ITEM + "=? AND " + Const.USER_DATE + "=? AND " + Const.USER_MESSAGE + "=?"
 */
/*
 try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, message.getMESSAGE_ID());
            prSt.setString(2, message.getUSER_NAME());
            prSt.setString(3, message.getUSER_PATRONYMIC());
            prSt.setString(4, message.getUSER_SECONDNAME());
            prSt.setString(5, message.getUSER_ITEM());
            prSt.setString(6, message.getUSER_DATE());
            prSt.setString(7, message.getUSER_MESSAGE());

            resSet = prSt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;
 */