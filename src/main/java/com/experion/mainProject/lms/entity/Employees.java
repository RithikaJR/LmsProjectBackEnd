package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="employees")
@DynamicUpdate
public class Employees {
    @Id
    @Column(name="emp_id")
    private Long employeeId;

    @Column(name="emp_firstname")
    private String employeeFirstName;
    @Column(name="emp_lasstname")
    private String employeeLastName;
    @Column(name="emp_email")
    private String employeeEmail;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="employees")
    @JsonIgnore
    private List<EnrolledCourse> enrolledCourses=new ArrayList<>();

    public Employees(Long employeeId, String employeeFirstName, String employeeLastName, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
    }

    public Employees() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}

