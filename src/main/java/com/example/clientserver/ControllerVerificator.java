package com.example.clientserver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerVerificator {
    @FXML
    private Button authorization;

    @FXML
    private Button AddNewsForUser;

    @FXML
    private Button ListNewsForUser;

    @FXML
    private Button NewsForUser;

    @FXML
    private Button groupVerificator;

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

        groupVerificator.setOnAction(event ->{
            newScene("menuGroup.fxml", groupVerificator);
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
