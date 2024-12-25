package com.xworkz.mall.runner;

import java.sql.*;
public class JDBC {
    public static void main(String[] args) {
        System.out.println("main method in running");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection is successful...");
            String url ="jdbc:mysql://localhost:3306/ecommerce";
            String user ="root";
            String password ="root";
            DriverManager.getConnection(url,user,password);
            System.out.println("JDBC Connection is established...");
        }catch (ClassNotFoundException | SQLException classNotFoundException)
        {
            System.out.println("JDBC Class not found"+classNotFoundException.getMessage());
        }
    }

}
