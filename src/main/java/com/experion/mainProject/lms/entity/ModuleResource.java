package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Time;

import javax.persistence.*;

@Entity
@Table(name = "module_resource")
@Getter
@Setter
public class ModuleResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_resource_id")
    private Long moduleResourceId;


    @Column(name = "module_resource_name")
    private String moduleResourceName;

    @Column(name = "module_resource_type")
    private String moduleResourceType;

    @Column(name = "module_resource_url")
    private String moduleResourceUrl;

    @Column(name = "module_resource_duration")
    private String moduleResourceDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

}
