package com.exam.allslow;

import java.sql.*;

public class DBManager {
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/allSlow";
        String userName = "root";
        String password = "";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}