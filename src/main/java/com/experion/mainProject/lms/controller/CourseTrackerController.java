//package com.experion.mainProject.lms.controller;
//
//import com.experion.mainProject.lms.dto.CourseTrackerRequest;
//import com.experion.mainProject.lms.service.CourseTrackerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//public class CourseTrackerController
//{
//    @Autowired
//    CourseTrackerService courseTrackerService;
//
//    @PostMapping("*/course-tracker")
//    public void trackCourse(@RequestBody CourseTrackerRequest courseTrackerRequest )
//    {
//        System.out.println(courseTrackerRequest);
//        courseTrackerService.enrollCoursetracker(courseTrackerRequest);
//    }
//}
