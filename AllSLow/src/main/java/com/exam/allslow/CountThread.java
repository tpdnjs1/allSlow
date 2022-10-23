package com.exam.allslow;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountThread extends Thread {

    private Label h;
    private Label m;
    private Label s;
    private long sec;

    private Label cal;

    public CountThread(Label h, Label m, Label s, long sec, Label cal) {
        this.h = h;
        this.m = m;
        this.s = s;
        this.sec = sec;
        this.cal = cal;
    }

    private boolean status = true;
    private boolean first = true;
    private boolean quit = false;

    public void setQuit() {
        quit = true;
    }

    ExerciseController exCon = new ExerciseController();

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String type = exCon.dbType;

    double dbCalorie = exCon.usedCalorie;
    double calorie;

    @Override
    public void run() {

        while (!quit) {
            try {
                Thread.sleep(1000);
                if (!status) continue;
                sec++;
            } catch (Exception e) {
                e.printStackTrace();
            }


            calorie = Math.floor((sec / 60 * dbCalorie) * 100) / 100.0;

            Long hour = sec / 3600;
            Long min = sec % 3600 / 60;
            Long second = sec % 60;


            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (hour < 10) {
                        h.setText("0" + hour);
                    } else {
                        h.setText(hour.toString());
                    }
                    if (min < 10) {
                        m.setText("0" + min);
                    } else {
                        m.setText(min.toString());
                    }
                    if (second < 10) {
                        s.setText("0" + second);
                    } else {
                        s.setText(second.toString());
                    }

                    if (calorie < 10) {
                        cal.setText("0" + calorie);
                        System.out.println(calorie + "1");
                    } else if (calorie > 100) {
                        calorie = Math.floor(calorie * 10) / 10.0;
                        cal.setText("" + calorie);
                        System.out.println(calorie + "2");
                    } else {
                        cal.setText(calorie + "");
                        System.out.println(calorie + "3");
                    }
                }
            });
        }
    }

    public void stopCount() {
        status = false;
        sec = 0;
        Platform.runLater(() -> {
            h.setText("00");
            m.setText("00");
            s.setText("00");
            cal.setText("00.00");
        });
    }

    public void pauseCount() {
        status = false;
    }

    public void startCount() {
        if (first) {
            this.start();
            first = false;
        } else {
            status = true;
        }
    }


}

