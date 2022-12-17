package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.UserProfileRepository;
import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.Role;
import com.experion.mainProject.lms.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileRepository userProfileRepository;


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
    public void updateInitialLoginStatus(ChangeStatus changeStatus,Long userId)
    {
        List<UserProfile> userProfiles= userProfileRepository.findAll();
        for(UserProfile profile:userProfiles){
            if(profile.getUserId()==userId){
                profile.setInitialStatus(changeStatus.isInitialStatus());
                userProfileRepository.save(profile);
            }
        }


    }


}
