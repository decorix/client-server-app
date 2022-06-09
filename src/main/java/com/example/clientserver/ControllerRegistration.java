package com.example.clientserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginInAcc;

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

    }

}
