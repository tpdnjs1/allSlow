package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

    @FXML
    private Button breakfast;
    @FXML
    private Button lunch;
    @FXML
    private Button dinner;
    @FXML
    private Button snack;
    @FXML
    private ToggleGroup group;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group = new ToggleGroup();

    }



}
