//package com.experion.mainProject.lms.dao;
//
//import com.experion.mainProject.lms.entity.Course;
//import com.experion.mainProject.lms.entity.Employees;
//import com.experion.mainProject.lms.entity.EnrolledCourse;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Date;
//import java.util.List;
//
//@RepositoryRestResource(collectionResourceRel = "EnrolledCourse", path="enrolled-course")
//@CrossOrigin(origins="*")
//public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse,Long> {
////   List<EnrolledCourse> findByEmployeeId(Long id);
//
////  Page<EnrolledCourse> findAllBymployees(@RequestBody Employees employee, Pageable pageable);
// void findByemployees(@RequestBody Employees employees);
//// void findByenrolledDate(@RequestBody Date date);
//
//}
