package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.EnrolledCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "EnrolledCourse", path="enrolled-course")
@CrossOrigin(origins="*")
public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse,Long> {
}
