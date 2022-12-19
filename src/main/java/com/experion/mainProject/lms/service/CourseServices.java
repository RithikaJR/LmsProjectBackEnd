package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.AddCourse;
import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.dto.RejectMailRequest;
import com.experion.mainProject.lms.entity.Course;

import javax.mail.MessagingException;
import java.util.List;

public interface CourseServices
{
     String addCourse(AddCourse addCourse);

     String addModule(AddModule addModule);
     void sendRejectMail(RejectMailRequest rejectMailRequest) throws MessagingException;

     List<Course> getEnrolledCourse(Long employeeId);
}
