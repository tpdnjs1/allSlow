package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpController {

    @FXML
    private TextField id;
    @FXML
    private PasswordField pw;
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
    private Button backBtn;
    @FXML
    private Button signUpBtn;

    @FXML
    private Label warnId;
    @FXML
    private Label warnPw;
    @FXML
    private Label warnName;
    @FXML
    private Label warnSex;
    @FXML
    private Label warnAge;
    @FXML
    private Label warnTall;
    @FXML
    private Label warnWeight;

    @FXML
    public void initialize() {
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


    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql;

    private boolean warn;

    public String uid;

    public void signUp() {
        canSignUp();
        if (!warn) {
            sql = "INSERT INTO `user`(`id`, `pw`, `name`, `sex`, `age`, `tall`, `weight`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id.getText());
                pstmt.setString(2, pw.getText());
                pstmt.setString(3, name.getText());
                pstmt.setString(4, sex.getValue());
                pstmt.setString(5, age.getText());
                pstmt.setString(6, tall.getText());
                pstmt.setString(7, weight.getText());
                pstmt.executeUpdate();

                sql = "SELECT * FROM `user` WHERE `id` = '" + id.getText() + "'";

                try {
                    pstmt = conn.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    uid = rs.getString("uid");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) signUpBtn.getScene().getWindow();
                    stage.setScene(scene);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void canSignUp() {
        int pass = 0;

        if (id.getText().isBlank()) {
            warnId.setText("*아이디가 입력되지 않았습니다.");
        } else if (id.getText().length() > 20) {
            warnId.setText("*아이디는 20자를 넘을 수 없습니다.");
        } else {
            String sql = "SELECT * FROM `user` WHERE `id` = '" + id.getText() + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                warnId.setText("");
                pass++;

                if (rs.next()) {
                    if (rs.getString("id").equals(id.getText())) {
                        warnId.setText("*동일한 아이디가 존재합니다.");
                        pass--;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (pw.getText().isBlank()) {
            warnPw.setText("*비밀번호가 입력되지 않았습니다.");
        } else if (pw.getText().length() > 20) {
            warnPw.setText("*비밀번호는 20자를 넘을 수 없습니다.");
        } else {
            warnPw.setText("");
            pass++;
        }

        if (name.getText().isBlank()) {
            warnName.setText("*닉네임이 입력되지 않았습니다.");
        } else if (name.getText().length() > 8) {
            warnName.setText("*닉네임은 8자를 넘을 수 없습니다.");
        } else {
            warnName.setText("");
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
            try {
                int num = Integer.parseInt(age.getText());
                warnAge.setText("");
                pass++;
            } catch (NumberFormatException e) {
                warnAge.setText("*숫자 외 다른 문자가 입력되었습니다.");
            }
        }


        if (tall.getText().isBlank()) {
            warnTall.setText("*키가 입력되지 않았습니다.");
        } else {
            try {
                int num = Integer.parseInt(tall.getText());
                warnTall.setText("");
                pass++;
            } catch (NumberFormatException e) {
                warnTall.setText("*키에 숫자 외 다른 문자가 입력되었습니다.");
            }
        }

        if (weight.getText().isBlank()) {
            warnWeight.setText("*몸무게가 입력되지 않았습니다.");
        } else {
            try {
                int num = Integer.parseInt(weight.getText());
                warnWeight.setText("");
                pass++;
            } catch (NumberFormatException e) {
                warnWeight.setText("*몸무게에 숫자 외 다른 문자가 입력되었습니다.");
            }
        }

        if (pass == 7) {
            warn = false;
        } else {
            warn = true;
        }
    }


}