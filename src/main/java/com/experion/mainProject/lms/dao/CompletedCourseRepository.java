package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.CompletedCourse;
import com.experion.mainProject.lms.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "completedCourse", path = "completed-course")
public interface CompletedCourseRepository extends JpaRepository<CompletedCourse,Long>
{
    Page<CompletedCourse> findByenrolledCourseId(@Param("id") Long enrolledCourseId, Pageable pageable);

    Page<CompletedCourse> findByemployeeId(@Param("id") Long employeeId, Pageable pageable);
}
