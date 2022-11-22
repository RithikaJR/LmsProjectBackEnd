package com.experion.mainProject.lms.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="course")
@Data
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
   @ManyToOne
   @JoinColumn(name="category_id", nullable = false)
   private CourseCategory category;

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;
    

}
