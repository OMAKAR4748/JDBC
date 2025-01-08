package com.xworkz.mall.runner;

import java.sql.*;

public class PreparedStatementRunner {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/country";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successfully");
            String query ="Insert into things values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,0);
            statement.setString(2,"Laptop");
            statement.setString(3,"Dell");
            statement.setString(4,"Grey");

            int rows =statement.executeUpdate();
            System.out.println("No of rows inserted :  "+rows);



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
