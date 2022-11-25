package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.entity.Module;
import com.experion.mainProject.lms.service.ModuleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class ModuleController {
    ModuleService moduleService;
    @GetMapping("*/modules")
    public List<Module> getAllModules() {
        return this.moduleService.getAllModule();
    }
}
