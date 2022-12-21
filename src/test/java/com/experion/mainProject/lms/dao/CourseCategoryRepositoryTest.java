package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseCategoryRepositoryTest
{
    @Autowired
    CourseCategoryRepository courseCategoryRepository;

    @Test
    void findAllCourseCategory()
    {
        List<CourseCategory> courseList = courseCategoryRepository.findAll();
        assertThat(courseList.size()).isEqualTo(5);

    }

}