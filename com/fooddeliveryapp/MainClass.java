package com.fooddeliveryapp;

import com.fooddeliveryapp.util.DBConnectionUtil;
import java.sql.Connection;

public class MainClass {
    public static void main(String[] args) {
        Connection connection = DBConnectionUtil.getInstance().getConnection();
        if (connection != null) {
            System.out.println("Database connection established successfully!");
        } else {
            System.out.println("Failed to establish database connection.");
        }
    }
}