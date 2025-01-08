package com.xworkz.mall.dao;

import java.sql.ResultSet;

public interface ThingsDao {

    int saveThings(String name,String brand, String color);

    ResultSet getAllThingsData();

}
