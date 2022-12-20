package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.UserProfile;
import lombok.Data;

@Data
public class JwtResponse {
    private UserProfile user;
    private String jwtToken;
  private Long roleId;
    private Long employeeId;
  private boolean initialStatus;

    public JwtResponse(UserProfile user, String jwtToken, Long roleId, boolean initialStatus,Long employeeId) {
        this.user = user;
        this.jwtToken = jwtToken;
        this.roleId = roleId;
        this.initialStatus = initialStatus;
        this.employeeId=employeeId;
    }
}
