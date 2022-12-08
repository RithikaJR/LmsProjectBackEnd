package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.CourseTracker;
//import com.experion.mainProject.lms.entity.CourseTrackingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "courseTracker", path="course-tracker")
@CrossOrigin(origins="*")
public interface CourseTrackerRepo extends JpaRepository<CourseTracker, Long>
{


}
