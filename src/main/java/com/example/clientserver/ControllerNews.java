package com.example.clientserver;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerNews {

    ObservableList<Message> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Message> tableForNews;

    @FXML
    private Button BackToUserMenu;

    @FXML
    private TableColumn<Message, String> tableDate;

    @FXML
    private TableColumn<Message, Integer> tableID;

    @FXML
    private TableColumn<Message, String> tableItem;

    @FXML
    private TableColumn<Message, String> tableMessage;

    @FXML
    private TableColumn<Message, String> tableName;

    @FXML
    private TableColumn<Message, String> tablePatronymic;

    @FXML
    private TableColumn<Message, String> tableSecondName;

    @FXML
    void initialize() {

        try {
            viewNews();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableID.setCellValueFactory(new PropertyValueFactory<Message, Integer>("MESSAGE_ID"));
        tableName.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_NAME"));
        tablePatronymic.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_PATRONYMIC"));
        tableSecondName.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_SECONDNAME"));
        tableItem.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_ITEM"));
        tableDate.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_DATE"));
        tableMessage.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_MESSAGE"));
        tableForNews.setItems(list);


        BackToUserMenu.setOnAction(event -> {
            if (Controller.status.equals("User")){
                newScene("menuForUser.fxml", BackToUserMenu);
            } else if (Controller.status.equals("Super-user")){
                newScene("menuForSuperUser.fxml",BackToUserMenu);
            } else if (Controller.status.equals("Verificator")){
                newScene("menuForVerificator.fxml", BackToUserMenu);
            } else {
                newScene("menuForGuests.fxml", BackToUserMenu);
            }
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

    public void viewNews() throws SQLException {
        DatabaseHandler db = new DatabaseHandler();
        Message message = new Message();

        ResultSet result = db.getNews(message);
        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String patronymic = result.getString("patronymic");
            String second_name = result.getString("second_name");
            String item = result.getString("item");
            String date = result.getString("date");
            String message1 = result.getString("message");
            //System.out.println("name: " + name + " patronymic: " + patronymic + " second_name: " + second_name + " item: " + item + " date: " + date + " message: " + message1);
            Message message2 = new Message(id, name, patronymic, second_name, item, date, message1);
            list.add(new Message(message2.getMESSAGE_ID(), message2.getUSER_NAME(), message2.getUSER_PATRONYMIC(), message2.getUSER_SECONDNAME(), message2.getUSER_ITEM(), message2.getUSER_DATE(), message2.getUSER_MESSAGE()));
        }

    }


}


