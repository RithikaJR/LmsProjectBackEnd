package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.EnrollCourse;
import com.experion.mainProject.lms.entity.Course;

import java.util.List;

public interface EnrolledCourseService {

    String enrollCourse(EnrollCourse enrollCourse);
    List<Course> getAllCourse(Long employeeId);
}
