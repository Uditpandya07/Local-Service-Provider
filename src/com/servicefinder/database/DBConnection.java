package com.servicefinder.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/servicefinder";
    private static final String USER = "root";
    private static final String PASSWORD = "u24052046";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully.");
            return con;
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            return null;
        }
    }
}