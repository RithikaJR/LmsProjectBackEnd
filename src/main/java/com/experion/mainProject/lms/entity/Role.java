package com.experion.mainProject.lms.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
@Data
public class Role {

    @Id
    @Column(name="role_id")
    private Long roleId;

    @Column(name="role_name")
    private String roleName;
}
