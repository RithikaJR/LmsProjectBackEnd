package com.experion.mainProject.lms.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private List<UserProfile> userProfiles = new ArrayList<>();


}
