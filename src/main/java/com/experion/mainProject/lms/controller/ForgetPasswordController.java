package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.ForgetPassword;
import com.experion.mainProject.lms.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
@CrossOrigin(origins = "*")
@RestController
public class ForgetPasswordController {
    @Autowired
    UserProfileService userProfileService;

    @PostMapping("*/user/forget-password")
    private String forgetPassword(ForgetPassword forgetPassword) throws MessagingException {
        System.out.println(forgetPassword.getEmployeeEmail());
        return userProfileService.forgetPasswordService(forgetPassword);
    }
}
