package com.experion.mainProject.lms.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;


    @Column(name = "course_name")
    private String courseName;


    @Column(name = "course_description")
    private String courseDescription;


    @Column(name = "course_image_url")
    private String courseImageUrl;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CourseCategory category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    @JsonIgnore
    private Set<Module> modules = new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseImageUrl='" + courseImageUrl + '\'' +
                ", category=" + category +
                ", modules=" + modules +
                '}';
    }

    public void add(Module module) {   //convenience method
//        if (module != null) {
//            if (modules == null) {
//                modules = new HashSet<>();
//            }

        modules.add(module);
        module.setCourse(this);
        }


    }

