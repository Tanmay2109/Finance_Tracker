package com.finance.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;

public class MainController {

    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        showDashboard();
    }

    @FXML
    public void showDashboard() {
        loadUI("dashboard.fxml");
    }

    @FXML
    public void showTransactions() {
        loadUI("transactions.fxml");
    }

    private void loadUI(String file) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + file));
            contentArea.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}