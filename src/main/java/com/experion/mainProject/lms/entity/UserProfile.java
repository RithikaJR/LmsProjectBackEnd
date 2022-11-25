//package com.experion.mainProject.lms.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="userprofile")
//@Data
//public class UserProfile {
//
//    @Id
//    @Column(name="user_id")
//    private Long userId;
//
//    @Column(name="user_firstname")
//    private String userFirstName;
//    @Column(name="user_lastname")
//    private String userLastName;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="role_id",referencedColumnName = "role_id")
//    private Role role;
//
//
//}
