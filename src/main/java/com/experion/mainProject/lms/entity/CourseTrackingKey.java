package com.experion.mainProject.lms.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseTrackingKey implements Serializable
{
  @Column(name = "course_id")
  Long courseId;

    @Column(name = "emp_id")
    Long employeeId;



}
