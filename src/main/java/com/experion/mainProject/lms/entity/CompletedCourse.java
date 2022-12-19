package com.experion.mainProject.lms.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "completed_course")
@Data

public class CompletedCourse
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "completed_course_id")
        private Long completedCourseId;

        @Column(name = "course_id",updatable = false)
        private Long courseId;

        @Column(name = "emp_id",updatable = false)
        private Long employeeId;

        @Column(name = "enrolled_course_id ")
        private Long enrolledCourseId;

        @Column(name = "status")
        private String completedStatus="completed";


}
