package com.example.clientserver;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerUser {
    @FXML
    private Button AddNewsForUser;

    @FXML
    private Button DeleteNewsForUser;

    @FXML
    private Button EditNewsForUser;

    @FXML
    private Button ListNewsForUser;

    @FXML
    private Button NewsForUser;

    @FXML
    private Button dataReset;

    @FXML
    private Button authorization;


    @FXML
    void initialize() {
        NewsForUser.setOnAction(event -> {
            newScene("news.fxml", NewsForUser);

        });
        AddNewsForUser.setOnAction(event -> {
            newScene("addNews.fxml", AddNewsForUser);
        });
        ListNewsForUser.setOnAction(event -> {
            newScene("listForNews.fxml", ListNewsForUser);
        });

        dataReset.setOnAction(event -> {
            newScene("dataReset.fxml", dataReset);
        });

        authorization.setOnAction(event ->{
            newScene("hello-view.fxml", authorization);
        });
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
