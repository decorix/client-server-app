package com.example.clientserver;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerListForUser {
    @FXML
    private TableColumn<?, ?> listDate;

    @FXML
    private TableView<?> listForNews;

    @FXML
    private TableColumn<?, ?> listID;

    @FXML
    private TableColumn<?, ?> listItem;

    @FXML
    private TableColumn<?, ?> listMessage;

    @FXML
    private TableColumn<?, ?> listName;

    @FXML
    private TableColumn<?, ?> listPatronymic;

    @FXML
    private TableColumn<?, ?> listSecondName;
}
