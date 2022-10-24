package com.exam.allslow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    SignUpController suCon = new SignUpController();
    SignInController siCon = new SignInController();

    String id;

    public void what(){
        if (siCon.wentToLgn) {
            id= siCon.id_;
        } else {
            String sql = "SELECT * FROM `user` WHERE `id` = '" + suCon.signId + "'";
            try {
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                id=rs.getString("id");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
