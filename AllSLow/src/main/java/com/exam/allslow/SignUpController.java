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

public class SignUpController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private PasswordField pw;
    @FXML
    private PasswordField checkPw;
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

    private boolean warn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sex.getItems().addAll("남성", "여성");

    }

    public void backLgn() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) backBtn.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        canSignUp();
        if (!warn) {
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

    private void canSignUp() {
        int pass = 0;

        if (id.getText().isBlank()) {
            warnId.setText("*아이디가 입력되지 않았습니다.");
        /*} else if () {
            warnId.setText("*동일한 아이디가 존재합니다.");
        */
        } else {
            warnId.setText("");
            pass++;
        }

        if (pw.getText().isBlank()) {
            warnPw.setText("*비밀번호가 입력되지 않았습니다.");
        } else if (!pw.getText().equals(checkPw.getText())) {
            warnPw.setText("*입력된 비밀번호와 일치하지않습니다.");
        } else {
            warnPw.setText("");
            pass++;
        }


        if (sex.getValue() == null) {
            warnSex.setText("*성별이 선택되지 않았습니다.");
        } else {
            warnSex.setText("");
            pass++;
        }


        if (age.getText().isBlank()) {
            warnAge.setText("*나이가 입력되지 않았습니다.");
        } else {
            warnAge.setText("*숫자 외 다른 문자가 입력되었습니다.");
        }
        warnAge.setText("");
        pass++;

        if (tall.getText().isBlank() || weight.getText().isBlank()) {
            warnSize.setText("*키 또는 몸무게가 입력되지 않았습니다.");
        } else {
            warnSize.setText("");
            pass++;
        }

        if (pass == 5) {
            warn = false;
        } else {
            warn = true;
        }
    }


}