package com.experion.mainProject.lms.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="course")
@Data
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private  Long courseId;


    @Column(name = "course_name")
    private String courseName;


    @Column(name = "course_description")
    private String courseDescription;


    @Column(name = "course_image_url")
    private String courseImageUrl;


    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private CourseCategory category;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="course")
    private List<Module> modules;


}
