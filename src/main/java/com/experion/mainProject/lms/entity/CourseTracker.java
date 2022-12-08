package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="course_tracker")
@Data
public class CourseTracker
{
    @EmbeddedId
    CourseTrackingKey id;



    @ManyToOne( fetch = FetchType.EAGER)
    @JsonIgnore
   @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course courses;

//    @Column(name="course_id")
//    private Long courseId;
    @ManyToOne( fetch = FetchType.EAGER)
    @JsonIgnore
    @MapsId("employeeId")
    @JoinColumn(name = "emp_id")
    private Employees employees;

    @Column(name = "course_name")
    private  String courseName;

    @Column(name = "status")
    private  String status;

    @Column(name = "assigned_date")
    private Date assignedDate;

    @Column(name = "completed_date")
    private Date completedDate;

//    @Column(name="course_id")
//     private Long course_id;
//
//    @Column(name="emp_id")
//   private Long emp_id;



}

//    @Column(name = "status")
//    private  String status;
//
//    @Column(name = "assigned_date")
//    private Date assignedDate;
//
//    @Column(name = "completed_date")
//    private Date completedDate;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name="emp_id", nullable = false)
//    private Employees employees;
//
//
//
////     @Column(name="course_id")
////     private Long course_id;
////
////    @Column(name="emp_id")
////    private Long emp_id;
//
//    //   @ManyToMany( fetch = FetchType.LAZY)
//    @ManyToMany(mappedBy = "courseTrackers")
//    Set<Course> courses;




