package com.xworkz.project.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
            preparedStatement = connection.prepareStatement("update product set PRODUCT_NAME=? where PRODUCT_ID=?");
            preparedStatement.setString(1,"Realmi");
            preparedStatement.setInt(2,5);
            int result =preparedStatement.executeUpdate();
            if(result==1){
                System.out.println("Updated");
            }else{
                System.out.println("Not Update");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(connection!=null) {
                    connection.close();
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
