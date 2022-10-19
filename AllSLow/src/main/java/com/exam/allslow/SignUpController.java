package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField pw;
    @FXML
    private TextField email;
    @FXML
    private TextField age;
    @FXML
    private TextField tall;
    @FXML
    private TextField weight;
    @FXML
    private ChoiceBox<String> sex = new ChoiceBox<>();

    @FXML
    private Button backBtn;
    @FXML
    private Button signUpBtn;

    @FXML
    private Label warnId;
    @FXML
    private Label warnPw;
    @FXML
    private Label warnSex;
    @FXML
    private Label warnAge;
    @FXML
    private Label warnSize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sex.getItems().addAll("남성", "여성");

    }

    public void backLgn(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) backBtn.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUp(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) signUpBtn.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
