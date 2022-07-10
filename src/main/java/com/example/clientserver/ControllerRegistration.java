package com.example.clientserver;

import java.io.IOException;
import java.net.URL;
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
            signUpNewUser();
        });

         BackMenu.setOnAction(event -> {

            BackMenu.getScene().getWindow().hide();

             FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource("hello-view.fxml"));
             try {
                 loader.load();
             } catch (IOException e) {
                 e.printStackTrace();
             }

             Parent root = loader.getRoot();
             Stage stage = new Stage();
             stage.setScene(new Scene(root));
             stage.showAndWait();
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String USER_EMAIL = email.getText();
        String USER_PASSWORD = inputPassword.getText();
        String USER_NICKNAME = nickname.getText();
        String USER_GROUPNUMBER = groupnumber.getText();
        String USER_PASSWORDAGAIN = inputPasswordAgain.getText();
        String USER_STATUS = "User";

        User user = new User(USER_EMAIL, USER_NICKNAME, USER_GROUPNUMBER, USER_PASSWORD, USER_PASSWORDAGAIN, USER_STATUS);


        dbHandler.signUpUser(user);

    }

}
