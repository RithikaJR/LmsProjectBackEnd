package com.experion.mainProject.lms.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="userprofile")
@Getter
@Setter
public class UserProfile {


    @Column(name="user_id")
    private Long userId;


@Id
   @Column(name="employee_id")
   private Long employeeId;



    @Column(name="user_firstname")
    private String userFirstName;
    @Column(name="user_lastname")
    private String userLastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id",referencedColumnName = "role_id")
    private Role role;


}
