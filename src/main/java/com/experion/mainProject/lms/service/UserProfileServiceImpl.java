//package com.experion.mainProject.lms.service;
//
//import com.experion.mainProject.lms.dao.UserProfileRepository;
//import com.experion.mainProject.lms.dto.RoleUpdate;
//import com.experion.mainProject.lms.dto.UpdateResponse;
//import com.experion.mainProject.lms.entity.UserProfile;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//
//public class UserProfileServiceImpl implements UserProfileService{
//    @Autowired
//    UserProfileRepository userProfileRepository;
//
//
//    @Override
//    public UpdateResponse update(RoleUpdate roleUpdate) {
//
//        if(userProfileRepository.findById(roleUpdate.getEmployeeId()).isPresent()){
//            UserProfile userProfile=userProfileRepository.findByroleName(roleUpdate.getroleName()).get();
//
//
//                userProfile.getRole().setRoleId(roleId);
//                userProfileRepository.save(userProfile);
//                return new UpdateResponse("Learning Admin added successfully!");
//
//
//
//
//
//        }
//
//        return new UpdateResponse("Employee does not exist");
//
//
//
//    }
//
//
//    //saving a specific record by using the method save() of CrudRepository
//
//}
