package com.exam.allslow;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CalendarController {
    @FXML
    private Label addCalorie;
    @FXML
    private Label increase;
    @FXML
    private DatePicker date;
    @FXML
    private ListView<FoodCal> fList;
    private ObservableList<FoodCal> fItems;
    @FXML
    private ListView<ExerciseCal> eList;
    private ObservableList<ExerciseCal> eItems;


    @FXML
    private void initialize() {
        addCalorie.setText("00.0");
        increase.setText("");
    }



}
