package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    private CountTread thread;
    private boolean status = false;

    @FXML
    private void initialize() {
        thread = new CountTread(hour, minute, second, 0);
    }

    public void start() {
        if (!status) {
            thread.startCount();
            startBtn.setText("일시 정지");
            status = true;
        } else {
            thread.pauseCount();
            startBtn.setText("재시작");
            status = false;
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
}
