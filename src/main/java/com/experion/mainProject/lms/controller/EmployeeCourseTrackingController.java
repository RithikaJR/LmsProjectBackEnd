package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.EmployeeCourseTracking;
import com.experion.mainProject.lms.dto.EmployeeCourseTrackingResponse;
import com.experion.mainProject.lms.service.EmployeeCourseTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeCourseTrackingController
{
    @Autowired
    EmployeeCourseTrackingService employeeCourseTrackingService;
    @PostMapping("*/employee-course-tracker")
    private EmployeeCourseTrackingResponse trackingResponse(@RequestBody EmployeeCourseTracking employeeCourseTracking)
    {

        return  employeeCourseTrackingService.trackedCourses(employeeCourseTracking);

    }

}
