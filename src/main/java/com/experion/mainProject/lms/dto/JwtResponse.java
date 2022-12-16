package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.UserProfile;
import lombok.Data;

@Data
public class JwtResponse {
    private UserProfile user;
    private String jwtToken;

    public JwtResponse(UserProfile user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }
}
