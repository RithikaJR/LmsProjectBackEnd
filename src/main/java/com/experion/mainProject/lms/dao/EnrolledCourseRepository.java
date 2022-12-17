package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.EnrolledCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "enrolledCourse", path = "enrolled-course")
public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse, Long>
{

}
