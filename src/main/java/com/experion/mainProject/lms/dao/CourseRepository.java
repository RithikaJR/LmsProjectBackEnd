package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Course;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "course", path = "courses")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('Super Admin') or hasRole('User')")
public interface CourseRepository extends JpaRepository<Course, Long>
{

    Page<Course> findBycourseNameContaining(@Param("name") String courseName, Pageable pageable);
    @Query("Select case when count(c) > 0 then true else false end from Course c where c.courseId = ?100")
    Boolean isCourseExistsBycourseId(Long courseId);

}
