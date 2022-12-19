package com.experion.mainProject.lms.dao;

import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.entity.UserProfile;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "userprofile", path="users")
@CrossOrigin(origins="*")

public interface UserProfileRepository extends JpaRepository<UserProfile,Long>
{
    Page<UserProfile> findByemployeeNameContaining(@Param("name") String employeeName, Pageable pageable);

    UserProfile findByuserName(String userName);
    UserProfile findByuserId(Long userId);




}
