package com.experion.mainProject.lms.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="course")
@Getter
@Setter
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
    @JsonIgnore
    @JoinColumn(name="category_id", nullable = false)
    private CourseCategory category;


    @OneToMany(cascade=CascadeType.ALL,mappedBy="course")
    @JsonIgnore
    private Set<Module> modules;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="courses")
    @JsonIgnore
    private List<CourseTracker> tracker;




    public void add(Module module)
    {
        System.out.println(modules.add(module));
        module.setCourse(this);
    }



}




//    @ManyToMany( fetch = FetchType.EAGER)
//    @JoinColumn(name="course_id", nullable = false)
//    private Course course;
//@ManyToMany
//@JoinTable(
//        name = "course_tracker",
//        joinColumns = @JoinColumn(name = "course_id"),
//        inverseJoinColumns = @JoinColumn(name = "tracking_id"))
//Set<CourseTracker> courseTrackers;
