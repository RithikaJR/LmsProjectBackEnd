package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.Role;
import com.experion.mainProject.lms.entity.UserProfile;

import javax.mail.MessagingException;

public interface UserProfileService {

    UserResponse userLogin(User user);

    String updateUser(Role role, Long employeeId);

    ChangePasswordResponse changePassword(ChangePassword changePassword);

    void updateInitialLoginStatus(ChangeStatus changeStatus, Long userId);

    String forgetPasswordService(ForgetPassword forgetPassword) throws MessagingException;

}
