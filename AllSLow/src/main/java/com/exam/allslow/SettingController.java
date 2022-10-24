package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    }

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql;



    UserDAO dao = new UserDAO();
    private final String uid = dao.id;

    public void update() {
        check();
        if (checkPass) {
            sql = "UPDATE `user` SET `id`= '" + dbId + "',`pw`= '" + dbPw + "', `name`= '" + dbName + "' , `age` = '" + dbAge + "', `tall` = '" + dbTall + "', `weight`= '" + dbWeight + "' WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                alert("", "정상적으로 기입되었습니다.");
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }


    private String dbId, dbPw, dbName, dbSex, dbAge, dbTall, dbWeight;

    private boolean checkPass = true;

    private void check() {
        if (!id.getText().isBlank() && id.getText().length() > 20) {
            alert("", "아이디는 20자를 넘을 수 없습니다.");
            checkPass =false;
        } else if (!id.getText().isBlank()) {
            int num = 0;

            sql = "SELECT * FROM `user` WHERE `id` = '" + id.getText() + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    if (rs.getString("id").equals(id.getText())) {
                        alert("", "동일한 아이디가 존재합니다.");
                        checkPass =false;
                        num++;
                    }
                }
                rs.close();
                if (num == 0) dbId = id.getText();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbId = rs.getString("id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!pw.getText().isBlank() && pw.getText().length() > 20) {
            alert("", "비밀번호는 20자를 넘을 수 없습니다.");
            checkPass =false;
        } else if (!pw.getText().isBlank()) {
            dbPw = pw.getText();
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbPw = rs.getString("pw");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!name.getText().isBlank() && name.getText().length() > 8) {
            alert("", "닉네임은 8자를 넘을 수 없습니다.");
            checkPass =false;
        } else if (!name.getText().isBlank()) {
            dbName = name.getText();
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbName = rs.getString("name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        if (sex.getValue() != null) {
            dbSex = sex.getValue();
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbSex = rs.getString("sex");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!age.getText().isBlank()) {
            try {
                int num = Integer.parseInt(age.getText());
                dbAge = age.getText();
            } catch (NumberFormatException e) {
                checkPass =false;
                alert("", "나이에 숫자 외 다른 문자가 입력되었습니다.");
            }
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbAge = rs.getString("age");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!tall.getText().isBlank()) {
            try {
                int num = Integer.parseInt(tall.getText());
                dbTall = tall.getText();
            } catch (NumberFormatException e) {
                checkPass =false;
                alert("", "키에 숫자 외 다른 문자가 입력되었습니다.");
            }
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbTall = rs.getString("tall");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!weight.getText().isBlank()) {
            try {
                int num = Integer.parseInt(weight.getText());
                dbWeight = weight.getText();
            } catch (NumberFormatException e) {
                checkPass =false;
                alert("", "몸무게에 숫자 외 다른 문자가 입력되었습니다.");
            }
        } else {
            sql = "SELECT * FROM `user` WHERE `uid` = '" + uid + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                dbWeight = rs.getString("weight");
            } catch (Exception e) {
                e.printStackTrace();
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
