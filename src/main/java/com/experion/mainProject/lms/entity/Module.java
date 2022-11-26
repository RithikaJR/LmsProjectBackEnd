package com.experion.mainProject.lms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="module")
@Data
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private  Long moduleId;


    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "module_image_url")
    private String moduleImageUrl;

    @Column(name = "module_url")
    private String moduleUrl;

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    private Course course;


}
