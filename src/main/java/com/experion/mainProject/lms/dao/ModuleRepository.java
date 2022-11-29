package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.entity.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource(collectionResourceRel = "module", path="modules")
@CrossOrigin(origins="*")
public interface ModuleRepository extends JpaRepository<Module,Long> {

//  Page<Module> findBycourseId(@Param("id") Long courseId, Pageable pageable);

}
