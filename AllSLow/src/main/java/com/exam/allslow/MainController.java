package com.exam.allslow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    SignUpController suCon = new SignUpController();
    SignInController siCon = new SignInController();

    public String uid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("calendar");
        if (siCon.wentToLgn) {
            uid = siCon.uid;
        } else {
            String sql = "SELECT * FROM `user` WHERE `id` = '" + suCon.signId + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                if (rs.getString("uid").isBlank()){
                    for (int checkUid = 0; rs.next(); checkUid++){
                        sql = "SELECT * FROM `user` WHERE `uid` = '" + checkUid + "'";
                        try {
                            pstmt = conn.prepareStatement(sql);
                            rs = pstmt.executeQuery();
                            if (!rs.getString("uid").equals(checkUid)){
                                continue;
                            }
                            uid = checkUid+"";
                            break;
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    rs.close();
                } else uid = rs.getString("uid");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private BorderPane pane;

    @FXML
    private void calendarPage(MouseEvent event) {
        loadPage("calendar");
    }

    @FXML
    private void exercisePage(MouseEvent event) {
        loadPage("exercise");
    }

    @FXML
    private void foodPage(MouseEvent event) {
        loadPage("food");
    }

    @FXML
    private void settingPage(MouseEvent event) {
        loadPage("setting");
    }


    public void loadPage(String page) {
        try {
            Parent nextScene = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            pane.setCenter(nextScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}