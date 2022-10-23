package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SettingController {
    @FXML
    private TextField id;
    @FXML
    private TextField pw;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField tall;
    @FXML
    private TextField weight;
    @FXML
    private ChoiceBox<String> sex = new ChoiceBox<>();

    @FXML
    public void initialize() {
        sex.getItems().addAll("남성", "여성");
        if (siCon.wentToLgn) {
            uid = siCon.uid;
        } else {
            uid = suCon.uid;
        }
    }

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    SignUpController suCon = new SignUpController();
    SignInController siCon = new SignInController();
    private String uid;

    public void update() {
        String sql = "UPDATE `user` SET `id`= ?,`pw`= ?,`name`= ?, `age` = ?, `tall` = ?, `id`=?, WHERE `uid` = '" + uid + "'";
    }


    private String dbId, dbPw, dbName, dbAge, dbTall, dbWeight;

    private int pass = 0;

    private void check() {
        if (!id.getText().isBlank() && id.getText().length() > 20) {
            alert("", "아이디는 20자를 넘을 수 없습니다.");
        } else if (!id.getText().isBlank()) {
            String sql = "SELECT * FROM `user` WHERE `id` = '" + id.getText() + "'";
            try {
                while (rs.next()) {
                    if (rs.getString("id").equals(id.getText())) {
                        alert("", "동일한 아이디가 존재합니다.");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!pw.getText().isBlank() && pw.getText().length() > 20) {
            alert("", "비밀번호는 20자를 넘을 수 없습니다.");
        } else if (!pw.getText().isBlank()) {

        }

        if (!name.getText().isBlank() && name.getText().length() > 8) {
            alert("", "닉네임은 8자를 넘을 수 없습니다.");
        } else if (!name.getText().isBlank()) {

        }

        if (sex.getValue() != null) {

        }

        if (!age.getText().isBlank()) {
            try {
                int num = Integer.parseInt(age.getText());

            } catch (NumberFormatException e) {
                alert("", "나이에 숫자 외 다른 문자가 입력되었습니다.");
            }
        }

        if (!tall.getText().isBlank()) {
            try {
                int num = Integer.parseInt(tall.getText());

            } catch (NumberFormatException e) {
                alert("", "키에 숫자 외 다른 문자가 입력되었습니다.");
            }
        }

        if (!weight.getText().isBlank()) {
            try {
                int num = Integer.parseInt(weight.getText());

            } catch (NumberFormatException e) {
                alert("", "몸무게에 숫자 외 다른 문자가 입력되었습니다.");
            }
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
