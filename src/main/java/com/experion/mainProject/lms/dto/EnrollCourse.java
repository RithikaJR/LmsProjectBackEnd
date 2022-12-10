package com.experion.mainProject.lms.dto;

import com.experion.mainProject.lms.entity.Course;
import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.entity.EnrolledCourse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class EnrollCourse {

    private Employees employeeId;
    private Course courseId;
    private Date enrolledDate;

}
