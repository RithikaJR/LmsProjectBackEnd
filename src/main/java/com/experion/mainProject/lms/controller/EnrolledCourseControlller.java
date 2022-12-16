package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.EnrollCourse;
import com.experion.mainProject.lms.dto.EnrollCourseResponse;
import com.experion.mainProject.lms.entity.EnrolledCourse;
import com.experion.mainProject.lms.service.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class EnrolledCourseControlller {
    @Autowired
    EnrolledCourseService enrolledCourseService;
    @PostMapping("*/enroll-course")
    @PreAuthorize("hasRole('User')")
    private String courseEnroll(@RequestBody EnrollCourse enrollCourse){
        System.out.println(enrollCourse);
        return enrolledCourseService.enrollCourse(enrollCourse);
    }
@GetMapping("*/enrolled-courses/{employeeId}")
   public EnrollCourseResponse getAllCourse(@PathVariable("employeeId") Long employeeId ) {
        EnrollCourseResponse enrollCourseResponse=enrolledCourseService.getAllCourse(employeeId);
        return enrollCourseResponse;

  }


}
