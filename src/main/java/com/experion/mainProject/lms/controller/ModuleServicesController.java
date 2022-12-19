package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.service.ModuleServices;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('Super Admin')")
    public String callAddModule(@RequestBody AddModule addModule) {
        String response = addModuleService.addModule(addModule);
        return response;

    }


}

