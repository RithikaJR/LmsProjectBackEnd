package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.ModuleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "moduleResource", path = "moduleResources")
@CrossOrigin(origins = "*")
public interface ModuleResourceRepository extends JpaRepository<ModuleResource,Long> {
}
