package com.xworkz.mall.runner;

import java.sql.*;

public class Library {
    public static void main(String[] args) throws SQLException {

        Connection connection= null;
        Statement statement =null;
        try{
            String url ="jdbc:mysql://localhost:3306/country";
            String user ="root";
            String password ="root";
            connection =DriverManager.getConnection(url,user,password);

//            String insert = "Insert into library values(0,'Kali','private','Rajajinager',1500,'Academic')";
//            String insert1 = "Insert into library values(0,'Tunga','Govt','Mangaluru',2000,'medical')";
//            String insert2 = "Insert into library values(0,'Sharavathi','private','Hassan',15000,'central')";
//            String insert3 = "Insert into library values(0,'kaveri','Govt','Hubbli',35000,'political')";
//            String insert4 = "Insert into library values(0,'yamuna','private','Madakeri',10000,'medical')";
//            String insert5 = "Insert into library values(0,'badra','Govt','dharwade',30000,'digital')";
//            String insert6 = "Insert into library values(0,'malaprabha','private','Belagavi',3000,'digital')";
//            String insert7 = "Insert into library values(0,'Ganga','Govt','Rajajinager',5000,'Academic')";

            statement =connection.createStatement();

//            statement.addBatch(insert);
//            statement.addBatch(insert1);
//            statement.addBatch(insert2);
//            statement.addBatch(insert3);
//            statement.addBatch(insert4);
//            statement.addBatch(insert5);
//            statement.addBatch(insert6);
//            statement.addBatch(insert7);

            statement.executeBatch();

            String select = "select * from library";
            ResultSet resultSet =statement.executeQuery(select);

            String count ="select count(*) from library where location='rajajinager'";
            ResultSet resultSet1 =statement.executeQuery(count);
           resultSet1.next();
                System.out.println(resultSet1.getInt(1));

            String query= "select count(*) from library where  l_types='central'";
            ResultSet resultSet2 =statement.executeQuery(query);
            while(resultSet2.next())
            {
                System.out.println(resultSet2.getInt(1));
            }

            String greater ="select count(*) from library where no_of_books > 10000";
            ResultSet resultSet3 =statement.executeQuery(greater);
           resultSet3.next();
                System.out.println(resultSet3.getInt(1));


        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            connection.close();
        }
    }
}
