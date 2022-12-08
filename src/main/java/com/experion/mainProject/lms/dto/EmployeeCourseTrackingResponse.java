package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.CourseTracker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class EmployeeCourseTrackingResponse
{
   private final  List<CourseTracker> tracker;


}
