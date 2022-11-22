package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "course", path="courses")

public interface CourseListRepository extends JpaRepository<Course,String> {
}
