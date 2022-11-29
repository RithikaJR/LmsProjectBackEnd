//package com.experion.mainProject.lms.controller;
//
//import com.experion.mainProject.lms.dto.RoleUpdate;
//import com.experion.mainProject.lms.dto.UpdateResponse;
//import com.experion.mainProject.lms.entity.UserProfile;
//import com.experion.mainProject.lms.service.UserProfileService;
//import com.experion.mainProject.lms.service.UserProfileServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins="*")
//public class UserProfileController {
//
//    @Autowired
//    UserProfileService userProfileService;
//
//@PostMapping("*/user/update")
//    private UpdateResponse update(@RequestBody RoleUpdate roleUpdate)
//    {
//       UpdateResponse updateResponse= userProfileService.update(roleUpdate);
//        return updateResponse;
//    }
//
//
//}
