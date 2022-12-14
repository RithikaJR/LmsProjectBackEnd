package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course_category")
@Getter
@Setter
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "category")
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    //Convenience method to add each course to corresponding category
    public void add(Course course) {
        System.out.println(courses.add(course));
        course.setCategory(this);
    }


}



