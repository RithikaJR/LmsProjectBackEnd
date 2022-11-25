package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.CourseCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "courseCategory",path="course-category")
@CrossOrigin(origins="*")
public interface CourseCategoryRepository extends JpaRepository<CourseCategory,String> {
    Page<CourseCategory> findAllBycategoryId(@Param("id")String categoryId, Pageable pageable);
}

