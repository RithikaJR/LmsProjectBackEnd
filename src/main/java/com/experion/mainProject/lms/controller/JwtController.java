package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.Role;
import com.experion.mainProject.lms.service.JwtService;
import com.experion.mainProject.lms.service.UserProfileService;
import com.experion.mainProject.lms.service.UserProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    UserProfileServiceImpl userProfileService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }


    @PutMapping("*/userupdate/{employeeId}")
    private String updateUser(@RequestBody Role role, @PathVariable("employeeId") Long employeeId){
        return  userProfileService.updateUser(role,employeeId);
    }

    @PutMapping("*/status-update/{userId}")
    private void updateInitialLoginStatus(@RequestBody ChangeStatus changeStatus, @PathVariable("userId") Long userId)
    {
        userProfileService.updateInitialLoginStatus(changeStatus, userId);
    }

    @PostMapping("*/user")
    private UserResponse update(@RequestBody User user)
    {
        UserResponse userResponse= userProfileService.userLogin(user);
        return userResponse;
    }

    @PostMapping("*/user/change-password")
    private ChangePasswordResponse changePassword(@RequestBody ChangePassword changePassword){
        return userProfileService.changePassword(changePassword);
    }



}
