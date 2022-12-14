package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "role", path = "roles")
@CrossOrigin(origins = "*")
public interface RoleRepository extends JpaRepository<Role, Long> {
}
