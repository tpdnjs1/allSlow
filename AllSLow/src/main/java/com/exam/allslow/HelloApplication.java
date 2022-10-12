package com.exam.allslow;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("/resources/EF_Diary.ttf"), 16);
        Font.loadFont(getClass().getResourceAsStream("/resources/KyoboHandwriting2020pdy.ttf"), 16);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("exercise.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("한강마렵다");
        stage.setScene(scene);
        stage.show();

       stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
           @Override
           public void handle(final WindowEvent windowEvent) {
               ExerciseController timer = new ExerciseController();
               timer.stopThread();
           }
       });
}//여기부터 고칠 것

    public static void main(String[] args) {
        launch(args);
    }
}