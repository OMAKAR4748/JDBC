package com.xworkz.mall.runner;

import com.xworkz.mall.dao.ThingsDao;
import com.xworkz.mall.dao.ThingsDaoImpl;

import java.sql.*;

public class ThingsRunner {

    public static void main(String[] args) throws SQLException {
        ThingsDao thingsDao =new ThingsDaoImpl();
//        int row= thingsDao.saveThings("Fan","Popular","white");
//        System.out.println("No of rows affected: "+row);

            ResultSet resultSet = thingsDao.getAllThingsData();
            try {
                boolean checkData = resultSet.next();
                if (checkData != false ) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String brand = resultSet.getString(3);
                        String color = resultSet.getString(4);

                        System.out.println(" Id :  " + id + " Name :  " + name + " Brand :  " + brand + " color :  " + color);
                    }
                }
                else
                {
                    System.out.println("Not data found");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }


    }
}
