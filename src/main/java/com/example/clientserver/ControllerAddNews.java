package com.example.clientserver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAddNews {

    @FXML
    private Button addNewsButtonAdd;

    @FXML
    private DatePicker addNewsDate;

    @FXML
    private TextField addNewsItem;

    @FXML
    private TextField addNewsMessage;

    @FXML
    private TextField addNewsName;

    @FXML
    private TextField addNewsPatronymic;

    @FXML
    private TextField addNewsSecondName;

    @FXML
    void initialize() {
        addNewsButtonAdd.setOnAction(event -> {
            String name = addNewsName.getText().trim();
            String patronymic = addNewsPatronymic.getText().trim();
            String second_name = addNewsSecondName.getText().trim();
            String item = addNewsItem.getText().trim();
            String date = String.valueOf(addNewsDate.getValue());
            String message1 = addNewsMessage.getText().trim();

            addMessageInDB(name,patronymic,second_name,item,date,message1);
            newScene("menuForUser.fxml", addNewsButtonAdd);
        });
    }
    public void addMessageInDB(String name, String patronymic, String second_name, String item, String date, String message1){
        DatabaseHandler dbHandler = new DatabaseHandler();
        Message message = new Message(name, patronymic, second_name, item, date, message1);
        dbHandler.addMessageDB(message);
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
