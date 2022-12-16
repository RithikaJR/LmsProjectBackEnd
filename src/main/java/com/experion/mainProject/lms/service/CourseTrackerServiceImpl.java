//package com.experion.mainProject.lms.service;
//
//import com.experion.mainProject.lms.dao.CourseTrackerRepo;
//import com.experion.mainProject.lms.dto.CourseTrackerRequest;
//import com.experion.mainProject.lms.entity.CourseTracker;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class CourseTrackerServiceImpl implements CourseTrackerService
//{
//
//
//   @Autowired
//    CourseTrackerRepo courseTrackerRepo;
//    @Override
//    public void enrollCoursetracker(CourseTrackerRequest courseTrackerRequest)
//    {
//        CourseTracker courseTracker = new CourseTracker();
//         courseTracker.setStatus(courseTrackerRequest.isStatus());
//         courseTracker.setEnrolledTrackerCourse(courseTrackerRequest.getEnrolledCourseId());
//         courseTracker.setModuleResource(courseTrackerRequest.getModuleResourceId());
//
//         courseTrackerRepo.save(courseTracker);
//
//
//    }
//}
