package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.ForgetPassword;
import com.experion.mainProject.lms.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
@CrossOrigin(origins = "*")
@RestController
public class ForgetPasswordController {


    @Autowired
    UserProfileService userProfileService;
    private static final Logger logger= LoggerFactory.getLogger(ForgetPasswordController.class);

    @PostMapping("*/user/forget-password")
    private String forgetPassword(ForgetPassword forgetPassword) throws MessagingException {
        logger.info("forget password");
        logger.error("forget password error");
        System.out.println(forgetPassword.getEmployeeEmail());
        return userProfileService.forgetPasswordService(forgetPassword);
    }
}
