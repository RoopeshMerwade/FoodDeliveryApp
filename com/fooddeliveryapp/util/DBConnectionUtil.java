
package com.fooddeliveryapp.util;
import java.sql.Connection;

import java.sql.DriverManager;

public class DBConnectionUtil {

    private static DBConnectionUtil instance;
    private Connection connection;

    private DBConnectionUtil() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddeliveryproject", "root", "admin@123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConnectionUtil getInstance() {
        if (instance == null) {
            synchronized (DBConnectionUtil.class) {
                if (instance == null) {
                    instance = new DBConnectionUtil();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}