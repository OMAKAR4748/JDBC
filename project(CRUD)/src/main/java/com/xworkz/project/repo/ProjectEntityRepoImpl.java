package com.xworkz.project.repo;

import com.xworkz.project.entity.ProjectEntity;
import com.xworkz.project.util.ProjectUtil;

import java.sql.*;
import java.util.List;

public class ProjectEntityRepoImpl implements ProjectEntityRepo {


    @Override
    public String insertData(List<ProjectEntity> projectEntities) {
        String result;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int check = 0;
        try {
            connection = ProjectUtil.loadDriverBuildConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?)");

            for (ProjectEntity projectEntity : projectEntities) {
                preparedStatement.setInt(1, projectEntity.getPRODUCT_ID());
                preparedStatement.setString(2, projectEntity.getPRODUCT_NAME());
                preparedStatement.setDouble(3, projectEntity.getPRICE());
                preparedStatement.setString(4, projectEntity.getCOMPANY_NAME());
                preparedStatement.setDate(5, Date.valueOf(projectEntity.getMANUFACTURE()));
                check += preparedStatement.executeUpdate();
            }

            if( check >= 0){
                result = "Inserted";
            } else {
                result = "Not inserted";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    @Override
    public int batchInsert() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ProjectUtil.loadDriverBuildConnection();
            String insert1 = "INSERT INTO product VALUES (0,'Redmi', 15000, 'XAMOII', '2024-01-20')";
            String insert2 = "INSERT INTO product VALUES (0,'Realmi', 16000, 'Realmi', '2023-11-25')";
            String insert3 = "INSERT INTO product VALUES (0,'Vivo', 14000, 'Vivo', '2022-07-12')";

            statement = connection.createStatement();
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);

            int[] row = statement.executeBatch();
            System.out.println("Number of rows inserted: " + row.length);
            System.out.println("-----------");
            return row.length;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
