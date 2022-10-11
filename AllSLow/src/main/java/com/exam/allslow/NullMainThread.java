package com.exam.allslow;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;



public class NullMainThread {
    EventHandler<WindowEvent> w = new EventHandler<WindowEvent> {
        private int a = 10;
        @Override
        public void run() {
            System.out.println("익명클래스입니다. " + a);
        }
    };

		w.run();
}
