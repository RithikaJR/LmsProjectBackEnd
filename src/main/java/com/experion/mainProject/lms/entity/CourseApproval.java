package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "course_approval")
@Data
@DynamicUpdate
//@IdClass(CourseApprovalId.class)
public class CourseApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_approval_id",updatable = false)
    private Long courseApprovalId;


//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "emp_id", nullable = false)
@Column(name = "emp_id",updatable = false)
    private Long employeeId;


//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "course_id", nullable = false)
@Column(name = "course_id",updatable = false)
    private Long courseId;


    @Column(name = "emp_name", updatable = false)
    private String employeeName;

    @Column(name = "emp_email", updatable = false)
    private String employeeEmail;


    @Column(name = "course_name", updatable = false)
    private String courseName;

    @Column(name = "course_id",updatable = false)
    private Long courseId;


    @Column(name = "approval_status")
    private String approvalStatus = "pending";

}
