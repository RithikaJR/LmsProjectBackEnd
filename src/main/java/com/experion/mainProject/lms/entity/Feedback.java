package com.experion.mainProject.lms.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
@Data
public class Feedback
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id",updatable = false)
    private Long feedbackId;

    @Column(name = "emp_id",updatable = false)
    private Long employeeId;

    @Column(name = "emp_name",updatable = false)
    private String employeeName;

    @Column(name = "feedback",updatable = false)
    private String feedback;

    @Column(name = "status")
    private boolean status;





}
