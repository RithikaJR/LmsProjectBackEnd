package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.EnrolledCourse;
import com.experion.mainProject.lms.entity.ModuleResource;
import lombok.Data;

@Data
public class CourseTrackerRequest {

    private EnrolledCourse enrolledCourseId;

    private ModuleResource moduleResourceId;

    private  boolean status;


}
