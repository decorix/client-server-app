package com.example.clientserver;

import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private TextField inputStatus;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private Button LoginGuest;

    @FXML
    void initialize() {
        LoginInAcc.setOnAction(event -> {
            String loginText = inputLogin.getText().trim();
            String loginPassword = inputPassword.getText().trim();
            String loginStatus = inputStatus.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword, loginStatus);
            } else {
                System.out.println("Error");
            }
        });

        Register.setOnAction(event -> {
            newScene("viewRegister.fxml", Register);
        });

        LoginGuest.setOnAction(event -> {
            newScene("menuForGuests.fxml", LoginGuest);
        });

    }

    private void loginUser(String loginText, String loginPassword, String loginStatus) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUSER_EMAIL(loginText);
        user.setUSER_PASSWORD(loginPassword);
        user.setUSER_STATUS(loginStatus);
        ResultSet result = dbHandler.getUser(user);


        int counter = 0;
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1 && user.getUSER_STATUS().equals("User")) {
            System.out.println("Success!");
            newScene("menuForUser.fxml", LoginInAcc);
        } else if (counter >= 1 && user.getUSER_STATUS().equals("Verificator")) {
            System.out.println("Success!");
            newScene("menuForVerificator.fxml", LoginInAcc);
        } else if (counter >= 1 && user.getUSER_STATUS().equals("Super-user")) {
            System.out.println("Success!");
            newScene("menuForSuperUser.fxml", LoginInAcc);
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
        stage.showAndWait();
    }

}