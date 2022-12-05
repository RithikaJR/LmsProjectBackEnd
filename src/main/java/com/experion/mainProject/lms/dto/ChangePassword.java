package com.experion.mainProject.lms.dto;

import lombok.Data;

@Data
public class ChangePassword {

    private Long employeeId;
    private String newPassword;
}
