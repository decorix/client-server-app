package com.example.clientserver;

import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginInAcc;

    @FXML
    private Button Register;

    @FXML
    private TextField inputLogin;

    @FXML
    private PasswordField inputPassword;

    @FXML
    void initialize() {
        LoginInAcc.setOnAction(event -> {
        String loginText = inputLogin.getText().trim();
        String loginPassword = inputPassword.getText().trim();

        if (!loginText.equals("") && !loginPassword.equals("")){
            loginUser(loginText, loginPassword);
        }else {
            System.out.println("Error");
        }
        });

        Register.setOnAction(event -> {

            Register.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("viewRegister.fxml"));

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

    private void loginUser(String loginText, String loginPassword) {
    }

}