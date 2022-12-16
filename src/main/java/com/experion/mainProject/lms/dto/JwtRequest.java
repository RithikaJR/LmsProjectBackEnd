package com.experion.mainProject.lms.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String userName;
    private String userPassword;
}
