package com.exam.allslow;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class CountTread extends Thread {

    private Label h;
    private Label m;
    private Label s;
    private long sec;

    public CountTread(Label h, Label m, Label s, long sec) {
        this.h = h;
        this.m = m;
        this.s = s;
        this.sec = sec;
    }

    private boolean status = true;
    private boolean first = true;
    private boolean quit = false;

    public void setQuit() {
        quit = true;
    }

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

            Long hour = sec / 3600;
            Long min = sec % 3600 / 60;
            Long second = sec % 60;

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (hour < 10){
                        h.setText("0"+hour.toString());
                    } else {
                        h.setText(hour.toString());
                    }
                    if (min < 10){
                        m.setText("0"+min.toString());
                    } else {
                        m.setText(min.toString());
                    }
                    if (second < 10){
                        s.setText("0"+second.toString());
                    } else {
                        s.setText(second.toString());
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
        });
    }

    public void pauseCount() {
        status = false;
    }

    public void startCount() {
        if(first) {
            this.start();
            first = false;
        }else {
            status = true;
        }
    }

}

