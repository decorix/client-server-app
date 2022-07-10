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



}
