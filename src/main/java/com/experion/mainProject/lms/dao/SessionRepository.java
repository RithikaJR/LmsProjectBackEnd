package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Module;
import com.experion.mainProject.lms.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "session", path = "session")
@CrossOrigin(origins = "*")
public interface SessionRepository extends JpaRepository<Session, Long> {
}
