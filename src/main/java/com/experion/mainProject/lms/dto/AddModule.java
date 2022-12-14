package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import com.experion.mainProject.lms.entity.Module;
import com.experion.mainProject.lms.entity.ModuleResource;
import lombok.Data;

import java.util.Set;

@Data
public class AddModule {


    private CourseCategory category;
    private Course course;
    private Module module;
    private Set<ModuleResource> moduleResourceItem;

}
