package com.example.clientserver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class ControllerReset {
    @FXML
    private Button backToMenuUser;

    @FXML
    private TextField email;

    @FXML
    private TextField groupnumber;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private TextField nickname;

    @FXML
    private Button reset;

    @FXML
    private Button reset1;

    @FXML
    private Button reset2;

    @FXML
    private Button reset3;

    @FXML
    void initialize() {
        reset.setOnAction(event -> {
            String str1 = "password";
            String password = inputPassword.getText().trim();
            resetData(password, str1);
        });
        reset1.setOnAction(event -> {
            String str2 = "nick";
            String nick = nickname.getText().trim();
            resetData(nick, str2);
        });
        reset2.setOnAction(event -> {
            String str3 = "group_number";
            String group_number = groupnumber.getText().trim();
            resetData(group_number, str3);
        });
        reset3.setOnAction(event -> {
            String str4 = "email";
            String email1 = email.getText().trim();
            resetData(email1, str4);
        });
        backToMenuUser.setOnAction(event -> {
            newScene("menuForUser.fxml", backToMenuUser);
        });
    }

    public void resetData(String data, String text) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();

        if (text.equals("password")) {
            user.setUSER_PASSWORD(data);
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
            //data = user.getUSER_PASSWORD();
            dbHandler.resetData(user, insert, data);
        } else if (text.equals("email")) {
            user.setUSER_EMAIL(data);
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_EMAIL + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
            //data = user.getUSER_EMAIL();
            dbHandler.resetData(user, insert, data);
        } else if (text.equals("nick")) {
            user.setUSER_NICKNAME(data);
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_NICKNAME + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
            String insert2 = "UPDATE " + Const.USER_TABLE2 + " SET " + Const.MESSAGE_NICKNAME + "=?" + " WHERE " + Const.MESSAGE_NICKNAME + "=?";
            //data = user.getUSER_NICKNAME();
            dbHandler.resetData(user, insert, data);
            dbHandler.resetData(user, insert2, data);
            Controller.nickname=data;
        } else {
            user.setUSER_GROUPNUMBER(data);
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_GROUPNUMBER + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
           //data = user.getUSER_GROUPNUMBER();
            dbHandler.resetData(user, insert, data);

        }

    }


    public void newScene(String scene, Button button) {
        button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(scene));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
/*
String sql = "";
        if (!user.getUSER_PASSWORD().equals("")) {
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";

        } else if (!user.getUSER_NICKNAME().equals("")) {
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_NICKNAME + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
        } else if (!user.getUSER_EMAIL().equals("")) {
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_EMAIL + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
        } else {
            String insert = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_GROUPNUMBER + "=?" + " WHERE " + Const.USER_NICKNAME + "=?";
        }
 */