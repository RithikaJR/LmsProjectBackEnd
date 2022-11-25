package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.ModuleRepository;
import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.entity.Module;

import java.util.List;
import java.util.Set;

public class ModuleService {
    ModuleRepository moduleRepo;
    public List<Module> getAllModule() {
        return this.moduleRepo.findAll();
    }
}
