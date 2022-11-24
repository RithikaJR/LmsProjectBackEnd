package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employees, Long> {
}
