package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "employees", path = "employee")
public interface EmployeeRepo extends JpaRepository<Employees, Long>
{
    Page<Employees> findByemployeeFirstNameContaining(@Param("name") String employeeFirstName, Pageable pageable);

}