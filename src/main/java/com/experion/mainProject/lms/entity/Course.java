package com.experion.mainProject.lms.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
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
    @JsonIgnore
    @JoinColumn(name = "category_id", nullable = false)
    private CourseCategory category;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "course")
    @JsonIgnore
    private Set<Module> modules = new HashSet<>();

    @OneToOne
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private EnrolledCourse enrolledCourse;

    //Convenience method to add each module to corresponding course
    public void add(Module module) {
        System.out.println(modules.add(module));
        module.setCourse(this);
    }

}
