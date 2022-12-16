package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseCategoryRepository;
import com.experion.mainProject.lms.dao.ModuleRepository;
import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import com.experion.mainProject.lms.entity.Module;
import com.experion.mainProject.lms.entity.ModuleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service

public class ModuleServicesImpl implements ModuleServices {

//    private CourseCategoryRepository courseCategoryRepository;
//
//    public ModuleServicesImpl(CourseCategoryRepository courseCategoryRepository) {
//        this.courseCategoryRepository = courseCategoryRepository;
//    }

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public String addModule(AddModule addModule) {
//        //retrive the course info from dto
//        Course course=addModule.getCourse();
//
//        //populate course with modules
//        Set<Module> moduleItems=addModule.getModuleItem();
//        moduleItems.forEach(item -> course.add(item));
//
//        //populate category with course
//        CourseCategory category=addModule.getCategory();
//        category.add(course);
//
//        //save to database
//        courseCategoryRepository.save(category);

        //retrive the module info from dto
        Module module = addModule.getModule();
        module.setCourse(addModule.getCourse());

        //populate module with module resource
        Set<ModuleResource> moduleResourceItems = addModule.getModuleResourceItem();
        moduleResourceItems.forEach(item -> module.add(item));

        //populate course with module
//        Course course = addModule.getCourse();
//        course.add(module);
//
//        //populate category with course
//        CourseCategory category = addModule.getCategory();
//        category.add(course);

        //save to database
        moduleRepository.save(module);


        return "Course added successfully!";

    }

}

