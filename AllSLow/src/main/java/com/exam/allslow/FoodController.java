package com.exam.allslow;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class FoodController implements Initializable {

    @FXML
    private ToggleButton breakfast;
    @FXML
    private ToggleButton lunch;
    @FXML
    private ToggleButton dinner;
    @FXML
    private ToggleButton snack;
    @FXML
    private ToggleGroup group;
    @FXML
    private DatePicker date;
    @FXML
    private TextField name;
    @FXML
    private TextField calorie;
    @FXML
    private ListView<WhatEat> list;

    private ObservableList<WhatEat> items;

    private String time = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group = new ToggleGroup();
        items = FXCollections.observableArrayList();
        list.setItems(items);
    }



    public void addEat(){
        String stName = name.getText();
        if (name.getText().isBlank()){
            alert("", "음식의 이름이 입력되지않았습니다.");
            return;
        }

        String stCal = calorie.getText();
        if (calorie.getText().isBlank()){
            alert("", "음식의 칼로리가 입력되지않았습니다");
            return;
        } else {
            try {
                int num = Integer.parseInt(calorie.getText());
            } catch (NumberFormatException e) {
                alert("위치: 칼로리", "숫자 외 다른 문자가 입력되었습니다.");
                return;
            }
        }

        LocalDate lcDate = date.getValue();
        if (date == null){
            alert("", "날짜가 입력되지않았습니다.");
            return;
        }

        if (breakfast.isSelected()) {
            time = "아침";
        }
        if (lunch.isSelected()) {
            time = "점심";
        }
        if (dinner.isSelected()) {
            time = "저녁";
        }
        if (snack.isSelected()) {
            time = "간식";
        }
        if (!breakfast.isSelected() && !lunch.isSelected() && !dinner.isSelected() && !snack.isSelected()){
            time = null;
        }

        if (time == null){
            alert("", "시간이 선택되지않았습니다.");
            return;
        }

        WhatEat whatEat = new WhatEat(stName, stCal, lcDate, time);
        items.add(whatEat);

    }

    public  void delWhatEat(){
        int idx = list.getSelectionModel().getSelectedIndex();
        if (idx >= 0){
            items.remove(idx);
        } else {
            alert("", "삭제할 아이템이 선택되지않았습니다.");
        }
    }

    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }


}
