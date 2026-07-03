package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/food_delivery_app";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hema@9676";

    private static Connection connection;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);

            System.out.println("Database Connected Successfully");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}