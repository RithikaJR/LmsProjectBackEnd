package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dto.AddCourse;
import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.dto.RejectMailRequest;

import javax.mail.MessagingException;

public interface CourseServices
{
     String addCourse(AddCourse addCourse);

     String addModule(AddModule addModule);
     void sendRejectMail(RejectMailRequest rejectMailRequest) throws MessagingException;
}
