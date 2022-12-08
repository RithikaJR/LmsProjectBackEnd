package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseTrackerRepo;
import com.experion.mainProject.lms.dto.EmployeeCourseTracking;
import com.experion.mainProject.lms.dto.EmployeeCourseTrackingResponse;
import com.experion.mainProject.lms.entity.CourseTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeCourseTrackingServiceImpl implements EmployeeCourseTrackingService
{
    @Autowired
    CourseTrackerRepo courseTrackerRepo;


    @Override
    public EmployeeCourseTrackingResponse trackedCourses(EmployeeCourseTracking employeeCourseTracking) {
        List<CourseTracker> courseTrackers = courseTrackerRepo.findAll();

        List<CourseTracker> trackedCourses=new ArrayList<>();

        for(CourseTracker courseTracker : courseTrackers)
        {
            if (courseTracker.getEmployees().getEmployeeId().longValue()==employeeCourseTracking.getEmployeeId())
            {
                trackedCourses.add(courseTracker);
            }
        }
        System.out.println(courseTrackers);
        return new EmployeeCourseTrackingResponse(trackedCourses);

    }
}
