package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseRepository;
import com.experion.mainProject.lms.dao.EnrolledCourseRepository;
import com.experion.mainProject.lms.dto.EnrollCourse;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.EnrolledCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EnrolledCourseServiceImpl implements EnrolledCourseService{
    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;
    EnrolledCourse enrolledCourse=new EnrolledCourse();

    @Override
    public String enrollCourse(EnrollCourse enrollCourse) {

       enrolledCourse.setEmployees(enrollCourse.getEmployeeId());
       enrolledCourse.setCourse(enrollCourse.getCourseId());
       enrolledCourse.setEnrolledDate(enrollCourse.getEnrolledDate());
        enrolledCourseRepository.save(enrolledCourse);


        return "Course enrolled successfully!";
    }
   public List<Course> getAllCourse(Long employeeId) {

        List<EnrolledCourse> enrolledCourses=enrolledCourseRepository.findAll();
        List<Course> coursesEnrolled=new ArrayList<>();

        for(EnrolledCourse enrolledCourse1:enrolledCourses)
        {
            if(Objects.equals(enrolledCourse1.getEmployees().getEmployeeId(), employeeId)){
                coursesEnrolled.add(enrolledCourse1.getCourse());
            }
        }



      return coursesEnrolled;
    }
}
