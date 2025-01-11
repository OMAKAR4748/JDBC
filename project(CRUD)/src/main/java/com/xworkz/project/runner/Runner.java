package com.xworkz.project.runner;

import com.xworkz.project.entity.ProjectEntity;
import com.xworkz.project.repo.ProjectEntityRepo;
import com.xworkz.project.repo.ProjectEntityRepoImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<ProjectEntity> list = new ArrayList<>();
        ProjectEntity project1 =new ProjectEntity(0, "Redmi", 15000, "XAMOII", LocalDate.of(2024, 1, 20));
        ProjectEntity project2 =new ProjectEntity(0, "Realmi", 16000, "Realmi", LocalDate.of(2023, 11, 25));
        ProjectEntity project3=new ProjectEntity(0, "Vivo", 14000, "Vivo", LocalDate.of(2022, 7, 12));
        list.add(project1);
        list.add(project2);
        list.add(project3);


        ProjectEntityRepo projectEntityRepo = new ProjectEntityRepoImpl();
        System.out.println(projectEntityRepo.insertData(list));
        System.out.println(projectEntityRepo.batchInsert());
    }
}
