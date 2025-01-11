package com.xworkz.project.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectEntity {

    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private double PRICE;
    private String COMPANY_NAME;
    private LocalDate MANUFACTURE;
}
