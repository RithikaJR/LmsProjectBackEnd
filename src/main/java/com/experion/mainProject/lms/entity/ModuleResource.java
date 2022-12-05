package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="module_resource")
@Getter
@Setter
public class ModuleResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_resource_id")
    private  Long moduleResourceId;



    @Column(name = "module_resource_name")
    private String moduleResourceName;

    @Column(name = "module_resource_type")
    private String moduleResourceType;

    @Column(name = "module_resource_url")
    private String moduleResourceUrl;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="module_id", nullable = false)
    private Module module;

}
