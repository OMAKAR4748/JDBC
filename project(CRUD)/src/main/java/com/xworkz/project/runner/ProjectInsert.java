package com.xworkz.project.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url ="jdbc:mysql://localhost:3306/country";
        String user ="root";
        String password = "root";
        String insert = "insert into country_info(Country_name,Country_capital) values(?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
           connection = DriverManager.getConnection(url, user,password);
           preparedStatement =connection.prepareStatement(insert);

           preparedStatement.setString(1,"Dubai");
           preparedStatement.setString(2,"ab");
           preparedStatement.executeUpdate();
            System.out.println("data Inserted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
