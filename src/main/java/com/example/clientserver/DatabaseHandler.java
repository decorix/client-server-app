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


    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD + "=?"; //+ Const.USER_STATUS + "=?";  AND " + Const.USER_NICKNAME + "=?"

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1, user.getUSER_EMAIL());
            prSt.setString(2, user.getUSER_PASSWORD());
            //prSt.setString(3, user.getUSER_STATUS());
            //prSt.setString(4, user.getUSER_NICKNAME());

            resSet = prSt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getNews(Message message) {
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

    public ResultSet getNewsForList(Message message) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE2 + " WHERE " + Const.USER_NICKNAME + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, Controller.nickname);
            resSet = prSt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;

    }

    public void addMessageDB(Message message) {
        String insert = "INSERT INTO " + Const.USER_TABLE2 + "(" + Const.USER_NAME + "," + Const.USER_PATRONYMIC + "," +
                Const.USER_SECONDNAME + "," + Const.USER_ITEM + "," + Const.USER_DATE + "," + Const.USER_MESSAGE + "," + Const.USER_NICKNAME + ")" + " VALUES" + "(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, message.getUSER_NAME());
            prSt.setString(2, message.getUSER_PATRONYMIC());
            prSt.setString(3, message.getUSER_SECONDNAME());
            prSt.setString(4, message.getUSER_ITEM());
            prSt.setString(5, message.getUSER_DATE());
            prSt.setString(6, message.getUSER_MESSAGE());
            prSt.setString(7, message.getUSER_NICKNAME());

            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editMessageDB(Message message) {
        String insert = "UPDATE " + Const.USER_TABLE2 + " SET " + Const.USER_NAME + "=?" + ", " + Const.USER_PATRONYMIC + "=?" + "," + Const.USER_SECONDNAME + "=?" + "," +
                Const.USER_ITEM + "=?" + ", " + Const.USER_DATE + "=?" + "," + Const.USER_MESSAGE + "=?" + " WHERE " + Const.MESSAGE_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, message.getUSER_NAME());
            prSt.setString(2, message.getUSER_PATRONYMIC());
            prSt.setString(3, message.getUSER_SECONDNAME());
            prSt.setString(4, message.getUSER_ITEM());
            prSt.setString(5, message.getUSER_DATE());
            prSt.setString(6, message.getUSER_MESSAGE());
            prSt.setInt(7, message.getMESSAGE_ID());


            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteMessageDB(Message message) {
        String insert = "DELETE FROM " + Const.USER_TABLE2 + " WHERE " + Const.MESSAGE_ID + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, message.getMESSAGE_ID());


            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet getNewsForGroup(Message message) {
        ResultSet resSet = null;

        String select = "SELECT " + "teacher." + Const.MESSAGE_ID + ", teacher." + Const.USER_NAME + ", teacher." + Const.USER_PATRONYMIC + ", teacher." +
                Const.USER_SECONDNAME + ", teacher." + Const.USER_ITEM + ", teacher." + Const.USER_DATE + ", teacher." + Const.USER_MESSAGE + ", teacher." +
                Const.MESSAGE_NICKNAME + ", verificator." + Const.VERIFICATOR_NAME +
                " FROM " + Const.USER_TABLE2 +
                " JOIN " + Const.USER_TABLE + " ON teacher." + Const.MESSAGE_NICKNAME + "=users." + Const.USER_NICKNAME +
                " JOIN " + Const.USER_TABLE3 + " ON verificator." + Const.VERIFICATOR_CONTROL_GROUP + "=users." + Const.USER_GROUPNUMBER +
                " WHERE verificator." + Const.VERIFICATOR_NAME + "=?";
        ;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, Controller.nickname);
            resSet = prSt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;

    }

    public void resetData(User user, String sql, String data) {

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(sql);
            prSt.setString(1, data);
            prSt.setString(2, Controller.nickname);


            prSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int countMessage(){
        int counter=0;
        String select = "SELECT COUNT(*) AS total FROM " + Const.USER_TABLE2 + " WHERE " + Const.MESSAGE_NICKNAME + "=?" + " GROUP BY " + Const.MESSAGE_NICKNAME;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, Controller.nickname);
            prSt.executeQuery();
            ResultSet resSet = prSt.getResultSet();
            if (resSet.next()){
                counter=resSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return counter;

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
            resSet = prSt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resSet;
 */

/*
 String select = "SELECT " + Const.MESSAGE_ID + ", " + Const.USER_NAME + ", " + Const.USER_PATRONYMIC + ", " +
                Const.USER_SECONDNAME + ", " + Const.USER_ITEM + ", "  + Const.USER_DATE + ", " +  Const.USER_MESSAGE + ", " +
                Const.MESSAGE_NICKNAME+ ", " + Const.VERIFICATOR_NAME  +
                " FROM " + Const.USER_TABLE2 +
                " JOIN " + Const.USER_TABLE + " ON " + Const.MESSAGE_NICKNAME + "=" + Const.USER_NICKNAME  +
                " JOIN " + Const.USER_TABLE3 + " ON " + Const.VERIFICATOR_CONTROL_GROUP + " = " + Const.USER_GROUPNUMBER +
                " WHERE " + Const.VERIFICATOR_NAME + " = " + Const.VERIFICATOR_NAME + "=?";
 */