package com.xworkz.mall.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class Bus {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection is successful...");
            String url = "jdbc:mysql://localhost:3306/Library";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("JDBC Connection is established...");

            String insert1 = "INSERT INTO books VALUES (0,'Harry Potter and the Philosopher Stone', 'Fantasy', '1997-06-26')";
            String insert2 = "INSERT INTO books VALUES (0,'A Game of Thrones', 'Fantasy', '1996-08-06')";
            String insert3 = "INSERT INTO books VALUES (0,'Thrones', 'Rockstar', '1996-08-06')";


            statement = connection.createStatement();

            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);


            statement.executeBatch();
            System.out.println("no of row insert:"+row.length);
            System.out.println("-----------");

            // Retrieve all data from the table
           String select = "SELECT * FROM books";
           ResultSet resultSet = statement.executeQuery(select);
           while (resultSet.next()) {
               System.out.println("Book ID: " + resultSet.getInt(1));
               System.out.println("Title: " + resultSet.getString(2));
               System.out.println("Genre: " + resultSet.getString(3));
               System.out.println("Publish Date: " + resultSet.getDate(4));
               System.out.println("-----------");
           }

            // Retrieve data by ID
           String Id = "SELECT * FROM books WHERE book_id = 2";
          ResultSet resultSet1 = statement.executeQuery(Id);
           if (resultSet1.next()) {
               System.out.println("Book ID: " + resultSet1.getInt(1));
               System.out.println("Title: " + resultSet1.getString(2));
               System.out.println("Genre: " + resultSet1.getString(3));
               System.out.println("Publish Date: " + resultSet1.getDate(4));
               System.out.println("-----------");
           }

            // Retrieve data by a specific field
           String query = "SELECT * FROM books WHERE genre = 'Fantasy'";
           ResultSet resultSet2 = statement.executeQuery(query);
           while (resultSet2.next()) {
               System.out.println("Book ID: " + resultSet2.getInt(1));
               System.out.println("Title: " + resultSet2.getString(2));
               System.out.println("Genre: " + resultSet2.getString(3));
               System.out.println("Publish Date: " + resultSet2.getDate(4));
               System.out.println("-----------");
           }

            // Retrieve data by ID and a specific field
             String query = "SELECT * FROM books WHERE book_id =3 AND genre = 'RockStar'";
           ResultSet resultSet3 = statement.executeQuery(query);
            if (resultSet3.next()) {
                System.out.println("Book ID: " + resultSet3.getInt(1));
                System.out.println("Title: " + resultSet3.getString(2));
                System.out.println("Genre: " + resultSet3.getString(3));
                System.out.println("Publish Date: " + resultSet3.getDate(4));
                System.out.println("-----------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("JDBC Class not found or SQL Exception: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing : " + e.getMessage());
            }
        }
    }
}


