package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseRepository;
import com.experion.mainProject.lms.dto.AddCourse;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseServices
{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String addCourse(AddCourse addCourse)
    {
        Course course = addCourse.getCourse();
        CourseCategory category= addCourse.getCategory();
        course.setCategory(category);
        courseRepository.save(course);
        return "Course added successfully!";
    }
}
