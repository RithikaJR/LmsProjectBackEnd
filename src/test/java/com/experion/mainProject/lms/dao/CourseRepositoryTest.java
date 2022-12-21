package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@PreAuthorize("hasRole('Super Admin') or hasRole('User')")
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    void setUp()
    {
        System.out.println("Testing-SetUp.....");
    }



    @Test
    void findAllCourses()
    {
        List<Course> courseList = courseRepository.findAll();
        assertThat(courseList.size()).isEqualTo(6);

    }
}