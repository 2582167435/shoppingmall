package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/shoppingbase";

    private  static Connection conn = null;
    private DB(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (null == conn) {
            new DB();
        }
        return conn;
      /*  try {
            conn = C3p0Utils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }*/
    }

}
