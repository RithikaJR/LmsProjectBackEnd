package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.UserProfileRepository;
import com.experion.mainProject.lms.dto.ChangePassword;
import com.experion.mainProject.lms.dto.User;
import com.experion.mainProject.lms.dto.UserResponse;
import com.experion.mainProject.lms.entity.Role;
import com.experion.mainProject.lms.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    UserProfileRepository userProfileRepository;



    @Override
    public UserResponse userLogin(User user) {
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
    Long roleId=null;
   String employeeName="";


        List<UserProfile> profile=userProfileRepository.findAll();


        for(UserProfile userProfile:profile){

            if((userProfile.getUserName().equalsIgnoreCase(user.getUserName())) && (bcrypt.matches(user.getUserPassword(),userProfile.getPassword()))){
                roleId=userProfile.getRole().getRoleId();
                employeeName=userProfile.getEmployeeName();
            }

        }


        return new UserResponse(roleId,employeeName);
    }

    @Override
    public String updateUser(Role role, Long employeeId) {

        List<UserProfile> profile=userProfileRepository.findAll();

        for(UserProfile userProfile:profile){

            if(Objects.equals(userProfile.getEmployee().getEmployeeId(), employeeId)){
                userProfile.setRole(role);
                userProfileRepository.save(userProfile);
                return "User updated successfully!";
            }
        }


        return "User not found!";
    }

    @Override
    public String changePassword(ChangePassword changePassword) {
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String encryptedPassword= bcrypt.encode(changePassword.getNewPassword());
        List<UserProfile> profile=userProfileRepository.findAll();
        for(UserProfile userProfile:profile){
            if(Objects.equals(userProfile.getEmployee().getEmployeeId(), changePassword.getEmployeeId())){
                userProfile.setPassword(encryptedPassword);
                userProfileRepository.save(userProfile);
                return "Password updated successfully!";

            }

        }

        return "User not found!";
    }


    //saving a specific record by using the method save() of CrudRepository

}
