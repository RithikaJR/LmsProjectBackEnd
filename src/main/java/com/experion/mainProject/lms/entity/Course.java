package com.experion.mainProject.lms.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
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

    @Column(name = "course_duration" )
    private String courseDuration;


    @Column(name = "course_rating" )
    private long courseRating;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="category_id", nullable = false)
    private CourseCategory category;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="course")
    @JsonIgnore
    private Set<Module> modules=new HashSet<>();

    @OneToOne
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private EnrolledCourse enrolledCourse;


    public void add(Module module){
//        if(course!=null){
//            if(courses==null){
//                courses=new HashSet<>();
//            }

        System.out.println(modules.add(module));
        module.setCourse(this);
    }

}
