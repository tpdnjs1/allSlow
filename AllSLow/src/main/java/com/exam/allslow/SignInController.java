package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private PasswordField pw;

    @FXML
    private Button loginBtn;

    @FXML
    private Label hyperlink;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hyperlink.setUnderline(true);

    }


    public void login() {



        try {
            Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveSignUp() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) hyperlink.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
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


