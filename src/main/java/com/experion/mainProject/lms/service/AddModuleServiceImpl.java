package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseCategoryRepository;
import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.dto.UpdateResponse;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import com.experion.mainProject.lms.entity.Module;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service

public class AddModuleServiceImpl implements AddModuleService{

private CourseCategoryRepository courseCategoryRepository;

    public AddModuleServiceImpl(CourseCategoryRepository courseCategoryRepository) {
        this.courseCategoryRepository = courseCategoryRepository;
    }

    @Override
    public void addModule(AddModule addModule) {
        //retrive the course info from dto
        Course course=addModule.getCourse();
        System.out.println(course);
        //populate course with modules
        Set<Module> moduleItems=addModule.getModuleItem();
        moduleItems.forEach(item -> course.add(item));

        //populate category with course
        CourseCategory category=addModule.getCategory();
        category.add(course);

        //save to database
        courseCategoryRepository.save(category);




    }
}
