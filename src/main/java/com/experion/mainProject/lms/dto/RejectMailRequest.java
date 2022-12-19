package com.experion.mainProject.lms.dto;

import lombok.Data;

@Data
public class RejectMailRequest {

    private String employeeName;
    private String employeeEmail;
    private String courseName;
}
