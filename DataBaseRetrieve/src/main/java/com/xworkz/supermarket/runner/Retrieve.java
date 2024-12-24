package com.xworkz.supermarket.runner;

import java.sql.*;
public class Retrieve {
    public static void main(String[] args) {

        Connection connection =null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Load Driver Connection successful...");
            String url ="jdbc:mysql://localhost:3306/Country";
            String user ="root";
            String password ="root";
            connection =DriverManager.getConnection(url,user,password);
            System.out.println("JDBC Connection is established...");
//            String insert1 = "insert into Country_Info values(0,'Germany','Berlin')";
//            String insert2 = "insert into Country_Info values(0,'Russia','Moscow')";
//            String insert3 = "insert into Country_Info values(0,'Sri Lanka','Colombo')";
            statement =connection.createStatement();



            int[] row = statement.executeBatch();
            System.out.println("no of row insert:"+row.length);

           String query ="select * from Country_Info";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                int Id = resultSet.getInt(1);
                String Country_name =resultSet.getString(2);
                String Country_capital =resultSet.getString(3);

                System.out.println("Contry Id: " +Id+ "   Country Name: " +Country_name+ "     Country Capital: "+Country_capital) ;
            }

        }catch (ClassNotFoundException | SQLException classNotFoundException)
        {
            System.out.println("JDBC Class not found"+classNotFoundException.getMessage());
        }
        finally {
            try{
                if (connection != null) {
                    connection.close();
                }

                if (statement != null)
                {
                    statement.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

