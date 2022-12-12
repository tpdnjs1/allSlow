package com.exam.allslow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/salad.png")));
        stage.setTitle("느루");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            terminate();
        });

    }

    public static void terminate() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}