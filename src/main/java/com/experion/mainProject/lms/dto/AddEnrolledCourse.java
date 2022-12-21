package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.Employees;
import lombok.Data;

import java.util.Date;

@Data
public class AddEnrolledCourse {

    private Employees employeeId;
    private Course courseId;
    private Date enrolledDate;
}
