package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import lombok.Data;

@Data
public class AddCourse
{
    private CourseCategory category;
    private Course course;
}
