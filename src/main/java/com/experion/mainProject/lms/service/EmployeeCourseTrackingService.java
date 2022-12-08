package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.EmployeeCourseTracking;
import com.experion.mainProject.lms.dto.EmployeeCourseTrackingResponse;
import com.experion.mainProject.lms.dto.UserResponse;

public interface EmployeeCourseTrackingService
{
    public EmployeeCourseTrackingResponse trackedCourses(EmployeeCourseTracking employeeCourseTracking);
}
