package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.ChangePassword;
import com.experion.mainProject.lms.dto.ChangePasswordResponse;
import com.experion.mainProject.lms.dto.User;
import com.experion.mainProject.lms.dto.UserResponse;
import com.experion.mainProject.lms.entity.Role;
import com.experion.mainProject.lms.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

@PostMapping("*/user")
    private UserResponse update(@RequestBody User user)
    {
       UserResponse userResponse= userProfileService.userLogin(user);
        return userResponse;
    }
@PutMapping("*/userupdate/{employeeId}")
@PreAuthorize("hasRole('Super Admin')")
private String updateUser(@RequestBody Role role, @PathVariable("employeeId") Long employeeId){
    return  userProfileService.updateUser(role,employeeId);
}

@PostMapping("*/user/change-password")
    private ChangePasswordResponse changePassword(@RequestBody ChangePassword changePassword){
    return userProfileService.changePassword(changePassword);
}

}
