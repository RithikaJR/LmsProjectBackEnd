package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.UserProfileRepository;
import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.Role;
import com.experion.mainProject.lms.entity.UserProfile;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@Service
public class UserProfileServiceImpl implements UserProfileService {


    @Autowired
    UserProfileRepository userProfileRepository;


    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    @Override
    public UserResponse userLogin(User user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Long roleId = null;
        String employeeName = "";
        Long employeeId = null;
        //to track newly logged-in user
        int userLoginTracker = 0;


        List<UserProfile> profile = userProfileRepository.findAll();


        for (UserProfile userProfile : profile) {

            if ((userProfile.getUserName().equalsIgnoreCase(user.getUserName())) && (bcrypt.matches(user.getUserPassword(), userProfile.getPassword()))) {
                roleId = userProfile.getRole().getRoleId();
                employeeName = userProfile.getEmployeeName();
                employeeId = userProfile.getEmployee().getEmployeeId();
                userLoginTracker = 0;
                break;
            } else if ((userProfile.getUserName().equalsIgnoreCase(user.getUserName())) && (user.getUserPassword().equals(userProfile.getPassword()))) {
                roleId = userProfile.getRole().getRoleId();
                employeeName = userProfile.getEmployeeName();
                employeeId = userProfile.getEmployee().getEmployeeId();
                userLoginTracker = 1;
                break;
            }

        }


        return new UserResponse(roleId, employeeName, employeeId, userLoginTracker);
    }

    @Override
    public String updateUser(Role role, Long employeeId) {

        List<UserProfile> profile = userProfileRepository.findAll();


       for (UserProfile userProfile : profile) {
           if (Objects.equals(userProfile.getEmployee().getEmployeeId(), employeeId)) {
                userProfile.setRole(role);
                userProfileRepository.save(userProfile);
                return "User updated successfully!";
          }
        }


        return "User not found!";
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePassword changePassword) {
        //update current password after verifying existing user
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(changePassword.getNewPassword());
        List<UserProfile> profile = userProfileRepository.findAll();
        for (UserProfile userProfile : profile) {
            if (Objects.equals(userProfile.getEmployee().getEmployeeId(), changePassword.getEmployeeId()) && Objects.equals(userProfile.getPassword(), changePassword.getCurrentPassword())) {
                userProfile.setPassword(encryptedPassword);
                userProfileRepository.save(userProfile);
                return new ChangePasswordResponse("Password updated successfully!");
            } else if (Objects.equals(userProfile.getEmployee().getEmployeeId(), changePassword.getEmployeeId()) && (bcrypt.matches(changePassword.getCurrentPassword(), userProfile.getPassword()))) {
                userProfile.setPassword(encryptedPassword);
                userProfileRepository.save(userProfile);
                return new ChangePasswordResponse("Password updated successfully!");

            }

        }

        return new ChangePasswordResponse(null);
    }

    @Override
    public void updateInitialLoginStatus(ChangeStatus changeStatus, Long userId) {
//to identify newly logged in user
        UserProfile profile = userProfileRepository.findByuserId(userId);
        profile.setInitialStatus(changeStatus.isInitialStatus());
        userProfileRepository.save(profile);


    }

    @Override
    public String forgetPasswordService(ForgetPassword forgetPassword) throws MessagingException {
        //to reset password after verifying existing user
        UserProfile userProfile = userProfileRepository.findByuserName(forgetPassword.getEmployeeEmail());


        if (userProfile != null) {


            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPassword = bcrypt.encode("experion@123");
            userProfile.setPassword(encryptedPassword);
            String response = sendMail(forgetPassword.getEmployeeEmail(),userProfile.getEmployeeName());
            userProfile.setInitialStatus(false);
            userProfileRepository.save(userProfile);
            return response;
        } else {


            return "User not found!";
        }

    }

    private String sendMail(String toEmail,String employeeName) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
        messageHelper.setSubject("L&D Team:Password reset");
        messageHelper.setText("Hi "+employeeName+",\nPlease use the following password to login\nPassword:'experion@123'\n" +
                "Please ensure to change the password after logging in.\nThanks&Regards,\nL&D Team");
        messageHelper.setFrom("lmslearningapp@gmail.com");
        messageHelper.setTo(toEmail);
        mailSender.send(message);
        return "Mail sent successfully!";

    }
}
