package com.experion.mainProject.lms.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class UserResponse {

    private final Long roleId;
    private final String employeeName;
    private final Long employeeId;


}
