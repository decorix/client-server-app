package com.example.clientserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(String email, String nickname, String groupNumber, String password, String passwordAgain) {
        if (password.equals(passwordAgain)) {
            String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_EMAIL + "," + Const.USER_PASSWORD + "," +
                    Const.USER_NICAKNAME + "," + Const.USER_GROUPNUMBER + ")" + " VALUES" + "(?,?,?,?)";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);

                prSt.setString(1, email);
                prSt.setString(2, password);
                prSt.setString(3, nickname);
                prSt.setString(4, groupNumber);

                prSt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Passwords don't match");
        }
    }


}
