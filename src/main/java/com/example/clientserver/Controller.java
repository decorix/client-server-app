package com.example.clientserver;

import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        Register.setOnAction(event ->  {
            System.out.println("Please, register!");
        });

        //Register.setOnAction();
    }

}