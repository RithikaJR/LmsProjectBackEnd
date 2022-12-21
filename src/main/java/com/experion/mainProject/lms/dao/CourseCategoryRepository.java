package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "courseCategory", path = "course-category")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('Super Admin')")
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, String> {
}
