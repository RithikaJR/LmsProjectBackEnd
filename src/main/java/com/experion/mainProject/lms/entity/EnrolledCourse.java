package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "enrolled_course")
@Data

public class EnrolledCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrolled_course_id")
    private Long enrolledCourseId;

    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "status")
    private String enrollStatus="enrolled";

    @Column(name = "enrolled_date")
    private Date enrolledDate;

    @Column(name = "employee_rating")
    private Long employeeRating;


}
