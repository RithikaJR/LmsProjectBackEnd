package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "course", path="courses")
@CrossOrigin(origins="*")
public interface CourseListRepository extends JpaRepository<Course,String> {
    Page<Course> findAllBycourseName(@Param("name")String courseName,Pageable pageable);
}
