package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.service.CourseServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController

public class CourseController
{
    @Autowired
    private CourseServices addCourseServices;


    @PostMapping("*/course/add-course")
//    @PreAuthorize("hasRole('Super Admin')")
    public ResponseEntity callAddCourse(@RequestBody AddCourse addCourse) {
        return  addCourseServices.addCourse(addCourse);


    }

    @PostMapping("*/module/add-module")
    @PreAuthorize("hasRole('Super Admin')")
    public ResponseEntity callAddModule(@RequestBody AddModule addModule) {
        return addCourseServices.addModule(addModule);


    }

    @PostMapping("*/course/reject-mail-notify")
    @PreAuthorize("hasRole('Super Admin')")
    public void courseRejectMail(@RequestBody RejectMailRequest rejectMailRequest) throws MessagingException {
        addCourseServices.sendRejectMail(rejectMailRequest);
    }


    @PostMapping("*/course/enroll-course")
   // @PreAuthorize("hasRole('User')")
    public void enrollCourse(@RequestBody AddEnrolledCourse addEnrolledCourse) {
        addCourseServices.enrollCourse(addEnrolledCourse);


    }



    @GetMapping("*/course/get-enrolled-course/{employeeId}")
    @PreAuthorize("hasRole('Super Admin') or hasRole('User')")
    public ListEnrolledCourseResponse enrolledCourse(@PathVariable Long employeeId){
        return addCourseServices.getEnrolledCourse(employeeId);
    }

}
