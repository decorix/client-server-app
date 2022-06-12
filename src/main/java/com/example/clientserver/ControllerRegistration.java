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
        DatabaseHandler dbHandler = new DatabaseHandler();
        Register.setOnAction(event -> {
            dbHandler.signUpUser(email.getText(), nickname.getText(), groupnumber.getText(), inputPassword.getText(), inputPasswordAgain.getText());
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

}
