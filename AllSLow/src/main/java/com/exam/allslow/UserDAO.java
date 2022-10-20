package com.exam.allslow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public void checkId(String checkingId){
        String sql = "SELECT * FROM `user` WHERE `id` '= " + checkingId + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("조회성공");
        } catch (Exception e){
            System.out.println(" ");
        }
    }

    public void checkPw(String checkingPw){
        String sql = "SELECT * FROM `user` WHERE `pw` '= " + checkingPw + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
        } catch (Exception e) {
            System.out.println(" ");
        }

    }
}
