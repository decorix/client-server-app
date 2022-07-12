package com.example.clientserver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerSuperUser {
    @FXML
    private Button authorization;
    @FXML
    private Button AddNewsForSuperUser;

    @FXML
    private Button ListNewsForSuperUser;

    @FXML
    private Button NewsForSuperUser;

    @FXML
    void initialize() {
        NewsForSuperUser.setOnAction(event -> {
            newScene("newsForSuperUser.fxml", NewsForSuperUser);

        });
        AddNewsForSuperUser.setOnAction(event -> {
            newScene("addNews.fxml", AddNewsForSuperUser);
        });
        ListNewsForSuperUser.setOnAction(event -> {
            newScene("listForNews.fxml", ListNewsForSuperUser);
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
