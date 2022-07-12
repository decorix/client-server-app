package com.example.clientserver;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackMenu;

    @FXML
    private Button Register;

    @FXML
    private TextField email;

    @FXML
    private TextField groupnumber;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private PasswordField inputPasswordAgain;

    @FXML
    private TextField nickname;

    @FXML
    void initialize() {
        Register.setOnAction(event -> {
            try {
                signUpNewUser();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            newScene("hello-view.fxml", Register);
        });

        BackMenu.setOnAction(event -> {
            newScene("hello-view.fxml", BackMenu);
        });
    }

    private void newScene(String scene, Button button) {
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

    private void signUpNewUser() throws NoSuchAlgorithmException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String USER_EMAIL = email.getText();
        String USER_PASSWORD = inputPassword.getText();
        String USER_NICKNAME = nickname.getText();
        String USER_GROUPNUMBER = groupnumber.getText();
        String USER_PASSWORDAGAIN = inputPasswordAgain.getText();
        String USER_STATUS = "User";

        String hash_Password = hashPassword(USER_PASSWORD);
        String hash_PasswordAgain = hashPassword(USER_PASSWORDAGAIN);

        User user = new User(USER_EMAIL, USER_NICKNAME, USER_GROUPNUMBER, hash_Password, hash_PasswordAgain, USER_STATUS);


        dbHandler.signUpUser(user);

    }
    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(password.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes){
            builder.append(String.format("%02X ", b));
        }
        return builder.toString().replaceAll(" ", "").toLowerCase();
    }

}
