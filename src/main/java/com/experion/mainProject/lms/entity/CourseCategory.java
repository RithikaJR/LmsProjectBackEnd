package com.experion.mainProject.lms.entity;

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
@Table(name="course_category")
@Data
public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private String categoryId;

    @Column(name="category_name")
    private String categoryName;

  @OneToMany(cascade=CascadeType.ALL,mappedBy="category")
   private List<Course> courses= new ArrayList<>();

    public void add(Course course){
//        if(course!=null){
//            if(courses==null){
//                courses=new HashSet<>();
//            }

            System.out.println(courses.add(course));
            course.setCategory(this);
        }


    }



