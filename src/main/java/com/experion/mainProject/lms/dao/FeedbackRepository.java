package com.experion.mainProject.lms.dao;


import com.experion.mainProject.lms.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "feedback", path = "feedback-form")
public interface FeedbackRepository extends JpaRepository<Feedback, Long>
{

}
