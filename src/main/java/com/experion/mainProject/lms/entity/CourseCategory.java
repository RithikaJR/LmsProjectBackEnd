package com.experion.mainProject.lms.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="course_category")
@Data
public class CourseCategory {
    @Id
    @Column(name="id")
    private String id;

    @Column(name="category_name")
    private String categoryName;

  @OneToMany(cascade=CascadeType.ALL,mappedBy="category")
   private Set<Course> courses;


}
