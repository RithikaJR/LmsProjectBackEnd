package com.experion.mainProject.lms.service;
import com.experion.mainProject.lms.dao.ModuleRepository;
import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.entity.Module;
import com.experion.mainProject.lms.entity.ModuleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service

public class ModuleServicesImpl implements ModuleServices {
    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public String addModule(AddModule addModule) {
        //retrive the module info from dto
        Module module = addModule.getModule();
        module.setCourse(addModule.getCourse());

        //populate module with module resource
        Set<ModuleResource> moduleResourceItems = addModule.getModuleResourceItem();
        moduleResourceItems.forEach(item -> module.add(item));


        //save to database
        moduleRepository.save(module);


        return "Module added successfully!";

    }

}

