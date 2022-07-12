package com.example.clientserver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerNewsForSuperUser {
    ObservableList<Message> list2 = FXCollections.observableArrayList();
    int index = -1;

    @FXML
    private AnchorPane listTable;

    @FXML
    private TableColumn<Message, String> listDate;

    @FXML
    private Button listDeleteNews;

    @FXML
    private Button listEditNews;

    @FXML
    private Button listButtonBack;

    @FXML
    private TableView<Message> listForNews;

    @FXML
    private TableColumn<Message, Integer> listID;

    @FXML
    private TableColumn<Message, String> listItem;

    @FXML
    private TableColumn<Message, String> listMessage;

    @FXML
    private TableColumn<Message, String> listName;

    @FXML
    private TableColumn<Message, String> listPatronymic;

    @FXML
    private TableColumn<Message, String> listSecondName;

    @FXML
    private TextField listDate2;

    @FXML
    private TextField listID2;

    @FXML
    private TextField listItem2;

    @FXML
    private TextField listMessage2;

    @FXML
    private TextField listName2;

    @FXML
    private TextField listPatronymic2;

    @FXML
    private TextField listSecondName2;


    @FXML
    void initialize() {

        try {
            viewNews();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listID.setCellValueFactory(new PropertyValueFactory<Message, Integer>("MESSAGE_ID"));
        listName.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_NAME"));
        listPatronymic.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_PATRONYMIC"));
        listSecondName.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_SECONDNAME"));
        listItem.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_ITEM"));
        listDate.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_DATE"));
        listMessage.setCellValueFactory(new PropertyValueFactory<Message, String>("USER_MESSAGE"));
        listForNews.setItems(list2);

        listButtonBack.setOnAction(event -> {
            if (Controller.status.equals("User")){
                newScene("menuForUser.fxml", listButtonBack);
            } else if (Controller.status.equals("Super-user")){
                newScene("menuForSuperUser.fxml",listButtonBack);
            } else {
                newScene("menuForVerificator.fxml", listButtonBack);
            }

        });


        listDeleteNews.setOnAction(event -> {
            deleteMessage();
        });

        listEditNews.setOnAction(event -> {
            editMessage();
        });


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
            list2.add(new Message(message2.getMESSAGE_ID(), message2.getUSER_NAME(), message2.getUSER_PATRONYMIC(), message2.getUSER_SECONDNAME(), message2.getUSER_ITEM(), message2.getUSER_DATE(), message2.getUSER_MESSAGE()));
        }

    }

    @FXML
    public void getSelected(javafx.scene.input.MouseEvent mouseEvent) {
        index = listForNews.getSelectionModel().getSelectedIndex();

        listID2.setText(listID.getCellData(index).toString());
        listMessage2.setText(listMessage.getCellData(index).toString());
        listName2.setText(listName.getCellData(index).toString());
        listPatronymic2.setText(listPatronymic.getCellData(index).toString());
        listSecondName2.setText(listSecondName.getCellData(index).toString());
        listItem2.setText(listItem.getCellData(index).toString());
        listDate2.setText(listDate.getCellData(index).toString());
    }

    public void deleteMessage() {
        int id = Integer.parseInt(listID2.getText());
        /*String message = listMessage2.getText().trim();
        String name = listName2.getText().trim();
        String patronymic = listPatronymic2.getText().trim()
        String second_name = listSecondName2.getText().trim();
        String item = listItem2.getText().trim();
        String date = listDate2.toString().trim();

         */
        System.out.println("id: " + id);
        DatabaseHandler db = new DatabaseHandler();
        Message message1 = new Message();
        message1.setMESSAGE_ID(id);
        db.deleteMessageDB(message1);
    }

    public void editMessage() {
        int id = Integer.parseInt(listID2.getText());
        String message = listMessage2.getText().trim();
        String name = listName2.getText().trim();
        String patronymic = listPatronymic2.getText().trim();
        String second_name = listSecondName2.getText().trim();
        String item = listItem2.getText().trim();
        String date = listDate2.getText().trim();

        DatabaseHandler db = new DatabaseHandler();
        Message message2 = new Message(id, name, patronymic, second_name, item, date, message);
        db.editMessageDB(message2);
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
