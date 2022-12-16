package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="course_tracker")
@Data

public class CourseTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_tracking_id")
    private  Long courseTrackingId;

    @Column(name = "status")
    private boolean status ;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="enrolled_course_id", nullable = false)
    private EnrolledCourse enrolledTrackerCourse;

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name="module_resource_id",referencedColumnName = "module_resource_id")
    private ModuleResource moduleResource;


}
