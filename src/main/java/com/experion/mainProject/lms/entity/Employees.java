package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
@DynamicUpdate
@Data
public class Employees {
    @Id
    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "emp_firstname")
    private String employeeFirstName;
    @Column(name = "emp_lastname")
    private String employeeLastName;
    @Column(name = "emp_email")
    private String employeeEmail;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "employee")
    @JsonIgnore
    private List<EnrolledCourse> enrolledCourses = new ArrayList<>();
public Employees(){

}
    public Employees(Long employeeId, String employeeFirstName, String employeeLastName, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
    }

}

