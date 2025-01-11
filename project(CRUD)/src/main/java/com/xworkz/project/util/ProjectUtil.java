package com.xworkz.project.util;

import com.xworkz.project.entity.ProjectEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjectUtil {
    public static Connection loadDriverBuildConnection()
    {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
