package com.experion.mainProject.lms.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "course_approval")
@Data
@SelectBeforeUpdate
@DynamicUpdate
public class CourseApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_approval_id")
    private Long courseApprovalId;

    @Column(name = "emp_id",updatable = false)
    private Long employeeId;


    @Column(name = "emp_name",updatable = false)
    private String employeeName;

    @Column(name = "course_name",updatable = false)
    private String courseName;

    @Column(name = "course_id",updatable = false)
    private Long courseId;


    @Column(name = "approval_status")
    private String approvalStatus="pending";

}
