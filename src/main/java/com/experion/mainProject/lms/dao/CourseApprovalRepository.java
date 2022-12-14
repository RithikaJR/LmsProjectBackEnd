package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.CourseApproval;
//import com.experion.mainProject.lms.entity.CourseApprovalId;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "courseApproval", path = "course-approval")
@CrossOrigin(origins = "*")
public interface CourseApprovalRepository extends JpaRepository<CourseApproval, Long>
{

}