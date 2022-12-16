//package com.experion.mainProject.lms.service;
//
//import com.experion.mainProject.lms.dao.EnrolledCourseRepository;
//import com.experion.mainProject.lms.dto.EnrollCourse;
//import com.experion.mainProject.lms.dto.EnrollCourseResponse;
//import com.experion.mainProject.lms.entity.Course;
//import com.experion.mainProject.lms.entity.EnrolledCourse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class EnrolledCourseServiceImpl implements EnrolledCourseService {
//    @Autowired
//    EnrolledCourseRepository enrolledCourseRepository;
//
//
//    @Override
//    public String enrollCourse(EnrollCourse enrollCourse) {
//        EnrolledCourse enrolledCourse = new EnrolledCourse();
//
//        enrolledCourse.setEmployees(enrollCourse.getEmployeeId());
//        enrolledCourse.setCourse(enrollCourse.getCourseId());
//        enrolledCourse.setEnrolledDate(enrollCourse.getEnrolledDate());
//        enrolledCourseRepository.save(enrolledCourse);
//
//
//        return "Course enrolled successfully!";
//    }
//
//    public EnrollCourseResponse getAllCourse(Long employeeId) {
//
//
//        List<EnrolledCourse> enrolledCourses = enrolledCourseRepository.findAll();
//        List<Course> coursesEnrolled = new ArrayList<>();
//        List<Long> enrolledCourseId = new ArrayList<>();
//
//        //to get the courses enrolled by each employee
//        for (EnrolledCourse enrolledCourse1 : enrolledCourses) {
//            if (Objects.equals(enrolledCourse1.getEmployees().getEmployeeId(), employeeId)) {
//                enrolledCourseId.add(enrolledCourse1.getEnrolledCourseId());
//                coursesEnrolled.add(enrolledCourse1.getCourse());
//            }
//        }
//
//
//        return new EnrollCourseResponse(coursesEnrolled, enrolledCourseId);
//
//    }
//}
