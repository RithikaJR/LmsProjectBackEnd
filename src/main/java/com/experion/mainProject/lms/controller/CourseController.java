package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.AddCourse;
import com.experion.mainProject.lms.service.CourseServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/add-course")
public class CourseController
{
    @Autowired
    private CourseServices addCourseServices;

//    public CourseController(CourseServices addCourseServices) {
//        this.addCourseServices = addCourseServices;
//    }

    @PostMapping("/add")
    public String callAddCourse(@RequestBody AddCourse addCourse) {
        String  response=addCourseServices.addCourse(addCourse);
        return response;

    }
}
