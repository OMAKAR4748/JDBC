package com.xworkz.project.runner;

import java.sql.*;

public class ProjectRead {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
            preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("PRODUCT_ID"));
                System.out.println(resultSet.getString("PRODUCT_NAME"));
                System.out.println(resultSet.getInt("PRICE"));
                System.out.println(resultSet.getString("COMPANY_NAME"));
                System.out.println(resultSet.getDate("MANUFACTURE"));
                System.out.println("===========================================");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
