package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dao.EnrolledCourseRepository;
import com.experion.mainProject.lms.dto.ChangePassword;
import com.experion.mainProject.lms.dto.EnrollCourse;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.service.EnrolledCourseService;
import com.experion.mainProject.lms.service.EnrolledCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class EnrolledCourseControlller {
    @Autowired
    EnrolledCourseService enrolledCourseService;
    @PostMapping("*/enroll-course")
    private String courseEnroll(@RequestBody EnrollCourse enrollCourse){
        System.out.println(enrollCourse);
        return enrolledCourseService.enrollCourse(enrollCourse);
    }
@GetMapping("*/enrolled-courses/{employeeId}")
   public List<Course> getAllCourse(@PathVariable("employeeId") Long employeeId ) {
     return enrolledCourseService.getAllCourse(employeeId);
  }


}
