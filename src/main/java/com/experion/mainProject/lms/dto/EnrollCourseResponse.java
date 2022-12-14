package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnrollCourseResponse {

    private final List<Course> enrolledCourseList;
    private final List<Long> enrolledCourseIdList;
}
