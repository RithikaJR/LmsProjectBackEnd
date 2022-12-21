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
@Table(name = "module")
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "module_serial_number")
    private int moduleSerialNumber;

    @Column(name = "module_name")
    private String moduleName;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "module")
    @JsonIgnore
    private List<ModuleResource> moduleResources = new ArrayList<>();

    //Convenience method to add each module resource to corresponding module
    public void add(ModuleResource moduleResource) {

        moduleResources.add(moduleResource);
        moduleResource.setModule(this);
    }


}
