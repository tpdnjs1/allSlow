package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private BorderPane pane;


    @FXML
    private void calendarPage(MouseEvent event) {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getClassLoader().getResource("calendar.fxml"));
            pane.setCenter(nextScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    private void checkpage(MouseEvent event) {
        loadPage("check");
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



    //이거 계속 오류남
    public void loadPage(String page) {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getClassLoader().getResource(page + ".fxml"));
            pane.setCenter(nextScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
