package com.xworkz.mall.dao;


import java.sql.*;

public class ThingsDaoImpl implements ThingsDao {
    @Override
    public int saveThings(String name, String brand, String color) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String url = "jdbc:mysql://localhost:3306/country";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement("Insert into things values(?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, brand);
            preparedStatement.setString(4, color);
            int rows = preparedStatement.executeUpdate();
            return rows;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            if (connection != null)

                try {
                    if (connection != null) {

                        connection.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    @Override
    public ResultSet getAllThingsData() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/country";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successfully");
            String select = "select * from things";
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}


