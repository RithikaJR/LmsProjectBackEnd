package com.experion.mainProject.lms.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name="role")
@Data
@DynamicUpdate
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;

    @Column(name="role_name")
    private String roleName;

    @OneToOne
    @PrimaryKeyJoinColumn
    private UserProfile userProfile;


}
