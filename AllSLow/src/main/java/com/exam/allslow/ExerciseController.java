package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExerciseController {

    @FXML
    private Label hour;
    @FXML
    private Label minute;
    @FXML
    private Label second;
    @FXML
    private Button startBtn;
    @FXML
    private Button stopBtn;

    @FXML
    private Label calorie;
    @FXML
    private ChoiceBox<String> exerciseType = new ChoiceBox<>();
    @FXML
    private TextField type;
    @FXML
    public TextField newUsedCalorie;

    private CountThread thread;
    private boolean status = false;

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM `exercise_calorie`";


    @FXML
    private void initialize() {
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                exerciseType.getItems().add(rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread = new CountThread(hour, minute, second, 12000, calorie);
    }

    String dbType = exerciseType.getValue();

    String typeValue;


    public boolean a = false;
    float usedCalorie;


    public void check() {
        if (type.getText().isBlank() || newUsedCalorie.getText().isBlank()) {
            alert("", "'종목명' 혹은 '분당 소모 칼로리' 가 입력되지않았습니다.");
        } else if (!newUsedCalorie.getText().isBlank()) {
            try {
                typeValue = exerciseType.getValue();
                usedCalorie = Float.parseFloat(newUsedCalorie.getText());
                alert("", "정상적으로 입력되었습니다.");
                a = true;
            } catch (NumberFormatException e) {
                alert("", "분당 소모 칼로리에 숫자 외 다른 문자가 입력되었습니다.");
            }
        } else {
            try {
                String sql = "SELECT * FROM `exercise_calorie` Where `type` = '" + dbType + "'";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    usedCalorie = Float.parseFloat(rs.getString("calorie"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        if (exerciseType.getValue() != null || usedCalorie != 0) {
            if (!status) {
                thread.startCount();
                startBtn.setText("일시 정지");
                status = true;
            } else {
                thread.pauseCount();
                startBtn.setText("재시작");
                status = false;
            }
        } else {
            alert("", "'종목' 혹은 '종목명'이 입력되지않았습니다.");

        }
    }

    public void stop() {
        thread.stopCount();
        startBtn.setText("시작");
        status = false;
    }

    public void stopThread() {
        thread.setQuit();
    }

    public void alert(String msg, String header) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("알림");
        alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.show();
    }
}
