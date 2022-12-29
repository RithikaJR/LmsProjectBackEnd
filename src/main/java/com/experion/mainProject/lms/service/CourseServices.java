package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.Course;
import org.springframework.http.ResponseEntity;

import javax.mail.MessagingException;
import java.util.List;

public interface CourseServices
{
     ResponseEntity addCourse(AddCourse addCourse);

     ResponseEntity addModule(AddModule addModule);
     void sendRejectMail(RejectMailRequest rejectMailRequest) throws MessagingException;

     void enrollCourse(AddEnrolledCourse addEnrolledCourse);

     ListEnrolledCourseResponse getEnrolledCourse(Long employeeId);
}
