package com.xworkz.project.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDelete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection =null;
        PreparedStatement preparedStatement =null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
            preparedStatement = connection.prepareStatement("delete from product where PRODUCT_ID =? and PRODUCT_NAME =?");
            preparedStatement.setInt(1,7);
            preparedStatement.setString(2,"Xperia V");
            int result =preparedStatement.executeUpdate();
            if(result==1){
                System.out.println("deleted");
            }else{
                System.out.println("Not deleted");
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
