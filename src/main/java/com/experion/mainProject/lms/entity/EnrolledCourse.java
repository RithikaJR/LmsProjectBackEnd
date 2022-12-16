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

    @Column(name = "enrolled_date")
    private Date enrolledDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "emp_id", nullable = false)
    private Employees employees;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;


}
