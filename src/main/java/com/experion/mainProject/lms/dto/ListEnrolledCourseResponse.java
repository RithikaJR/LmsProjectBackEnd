package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.EnrolledCourse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListEnrolledCourseResponse {
    List<Course> coursesEnrolled;
    List<EnrolledCourse> enrolledCourseId;
}
