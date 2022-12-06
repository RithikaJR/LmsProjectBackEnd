package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseRepository;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.Module;
import org.hibernate.service.spi.InjectService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseModule {

    private CourseRepository courseRepository;

    public CourseModule(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void displayCourseModules()
    {
        long id = 100;
        Optional<Course> course = courseRepository.findById(id);
            Set<Module> module = course.get().getModules();
            System.out.println(module);

    }

}
