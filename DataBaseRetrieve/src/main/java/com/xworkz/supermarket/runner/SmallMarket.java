package com.xworkz.supermarket.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SmallMarket{
    public static void main(String[] args) {
        System.out.println("main method running");

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            String url = "jdbc:mysql://localhost:3306/Country";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("JDBC Connection established");

            Statement statement = connection.createStatement();

            String insert = "INSERT INTO Country_Info  VALUES (0,'Indonesia', 'Jakarta')";
            statement.addBatch(insert);

            int[] rows = statement.executeBatch();
            System.out.println("Number of rows inserted: " + rows.length);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            try {

                    connection.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

