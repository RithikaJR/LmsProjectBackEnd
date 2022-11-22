package com.experion.mainProject.lms.entity;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="courseList")
@Data
public class CourseList
{
    @Id
    @Column(name = "courseId")
    private  String courseId;
    @ManyToOne
    @JoinColumn(name="categoryId", nullable = false)
    private CourseCategory category;

    @Column(name = "courseName")
    private String courseName;


    @Column(name = "courseDescreption")
    private String courseDescreption;

    @Column(name = "CourseUrl")
    private String CourseUrl;
    

}
