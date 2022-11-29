package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.service.AddModuleService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/add-module")

public class AddModuleController {
    private AddModuleService addModuleService;

    public AddModuleController(AddModuleService addModuleService) {
        this.addModuleService = addModuleService;
    }

    @PostMapping("/add")
    public void callAddModule(@RequestBody AddModule addModule) {
        addModuleService.addModule(addModule);

    }
}
