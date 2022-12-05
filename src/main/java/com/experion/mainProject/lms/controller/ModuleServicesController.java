package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.service.ModuleServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/add-module")

public class ModuleServicesController {
    private ModuleServices addModuleService;

    public ModuleServicesController(ModuleServices addModuleService) {
        this.addModuleService = addModuleService;
    }

    @PostMapping("/add")
    public String callAddModule(@RequestBody AddModule addModule) {
        String  response=addModuleService.addModule(addModule);
        return response;

    }

//    @DeleteMapping("/courses/{courseId}")
//    public List<Course> deleteCourse(@PathVariable Long courseId)
//    {
//
//        return (List<Course>) this.addModuleService.deleteCourse(courseId);
//
//    }
}

