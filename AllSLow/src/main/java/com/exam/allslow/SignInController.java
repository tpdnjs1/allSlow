package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    public void signUp() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource())
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
