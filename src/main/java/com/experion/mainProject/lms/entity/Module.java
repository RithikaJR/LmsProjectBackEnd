package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="module")
@Getter
@Setter
public class Module {
    @Id
    @Column(name = "module_id")
    private  Long moduleId;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "module_image_url")
    private String moduleImageUrl;

    @Column(name = "module_url")
    private String moduleUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="course_id", nullable = false)
    private Course course;


}
