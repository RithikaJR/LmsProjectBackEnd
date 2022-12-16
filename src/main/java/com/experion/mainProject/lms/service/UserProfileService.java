package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.ChangePassword;
import com.experion.mainProject.lms.dto.ChangePasswordResponse;
import com.experion.mainProject.lms.dto.User;
import com.experion.mainProject.lms.dto.UserResponse;
import com.experion.mainProject.lms.entity.Role;

public interface UserProfileService {

    UserResponse userLogin(User user);

    String updateUser(Role role, Long employeeId);

    ChangePasswordResponse changePassword(ChangePassword changePassword);
}
