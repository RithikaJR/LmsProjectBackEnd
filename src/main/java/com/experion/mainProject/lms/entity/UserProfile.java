package com.experion.mainProject.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "userprofile")
@Setter
@Getter
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;


    @Column(name = "emp_name")
    private String employeeName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String password;
    @Column(name = "initial_status ")
    private boolean initialStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employees employee;

}
