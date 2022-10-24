package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("calendar");

    }

    @FXML
    private BorderPane pane;

    @FXML
    private void calendarPage(MouseEvent event) {
        loadPage("calendar");
    }

    @FXML
    private void exercisePage(MouseEvent event) {
        loadPage("exercise");
    }

    @FXML
    private void foodPage(MouseEvent event) {
        loadPage("food");
    }

    @FXML
    private void settingPage(MouseEvent event) {
        loadPage("setting");
    }


    public void loadPage(String page) {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            pane.setCenter(nextScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}