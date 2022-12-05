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
@Table(name="module")
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private  Long moduleId;

    @Column(name = "module_number")
    private  int moduleNumber;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "module_video_url")
    private String moduleVideoUrl;

    @Column(name = "module_pdf_url")
    private String modulePdfUrl;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="course_id", nullable = false)
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    @JsonIgnore
    private List<ModuleResource> moduleResources = new ArrayList<>();

    public void add(ModuleResource moduleResource) {   //convenience method
//        if (module != null) {
//            if (modules == null) {
//                modules = new HashSet<>();
//            }

        moduleResources.add(moduleResource);
        moduleResource.setModule(this);
    }


}
