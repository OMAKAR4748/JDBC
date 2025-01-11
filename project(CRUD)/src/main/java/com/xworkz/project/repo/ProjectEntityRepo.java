package com.xworkz.project.repo;

import com.xworkz.project.entity.ProjectEntity;

import java.util.List;

public interface ProjectEntityRepo {

    String insertData(List<ProjectEntity> projectEntity);

    int batchInsert();
}
