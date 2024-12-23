package com.xworkz.supermarket.runner;
import java.sql.*;
public class Jdbc {
    public static void main(String[] args) {
        System.out.println("main method in running");

        Connection connection =null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //load driver
            System.out.println("Connection is successful...");
            String url ="jdbc:mysql://localhost:3306/Country"; //establsh the connection
            String user ="root";
            String password ="root";
            connection =DriverManager.getConnection(url,user,password);
            System.out.println("JDBC Connection is established...");
            String insert1 = "insert into Country_Info values(5,'Germany','Berlin')";
            String insert2 = "insert into Country_Info values(6,'Russia','Moscow')";
            String insert3 = "insert into Country_Info values(7,'Sri Lanka','Colombo')";
            Statement statement =connection.createStatement();
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);

            int[] row = statement.executeBatch();
            System.out.println("no of row insert:"+row.length);

        }catch (ClassNotFoundException | SQLException classNotFoundException)
        {
            System.out.println("JDBC Class not found"+classNotFoundException.getMessage());
        }
        finally {
           try{
               connection.close();
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
        }
    }
}
