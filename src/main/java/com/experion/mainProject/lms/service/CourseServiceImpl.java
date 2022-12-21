package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseRepository;
import com.experion.mainProject.lms.dao.EnrolledCourseRepository;
import com.experion.mainProject.lms.dao.ModuleRepository;
import com.experion.mainProject.lms.dto.AddCourse;
import com.experion.mainProject.lms.dto.AddEnrolledCourse;
import com.experion.mainProject.lms.dto.AddModule;
import com.experion.mainProject.lms.dto.RejectMailRequest;
import com.experion.mainProject.lms.entity.*;
import com.experion.mainProject.lms.entity.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseServices
{
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrolledCourseRepository enrolledCourseRepository;

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    @Override
    public String addCourse(AddCourse addCourse)
    {
        Course course = addCourse.getCourse();
        CourseCategory category= addCourse.getCategory();
        course.setCategory(category);
        courseRepository.save(course);
        return "Course added successfully!";
    }



    @Override
    public String addModule(AddModule addModule) {
        //retrive the module info from dto
        Module module = addModule.getModule();
        module.setCourse(addModule.getCourse());

        //populate module with module resource
        Set<ModuleResource> moduleResourceItems = addModule.getModuleResourceItem();
        moduleResourceItems.forEach(item -> module.add(item));


        //save to database
        moduleRepository.save(module);


        return "Module added successfully!";

    }


    @Override
    public void sendRejectMail(RejectMailRequest rejectMailRequest) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
        messageHelper.setSubject("L&D Team:Course Approval");
        messageHelper.setText("Hi "+rejectMailRequest.getEmployeeName()+",\nWe regret to inform you that the course "
                +"'"+rejectMailRequest.getCourseName()+"'"+" that you have enrolled for has been rejected.Please ensure to enroll for courses " +
                "that are relevant to your current domain\nThanks & Regards,\nL&D Team");
        messageHelper.setFrom("lmslearningapp@gmail.com");
        messageHelper.setTo(rejectMailRequest.getEmployeeEmail());
        mailSender.send(message);


    }

    @Override
    public void enrollCourse(AddEnrolledCourse addEnrolledCourse) {
        EnrolledCourse enrolledCourse=new EnrolledCourse();
        enrolledCourse.setEnrolledDate(addEnrolledCourse.getEnrolledDate());
        enrolledCourse.setEmployee(addEnrolledCourse.getEmployeeId());
        enrolledCourse.setCourse(addEnrolledCourse.getCourseId());
        enrolledCourseRepository.save(enrolledCourse);
    }


    @Override
    public List<Course> getEnrolledCourse(Long employeeId) {

        List<EnrolledCourse> enrolledCourses=enrolledCourseRepository.findAll();
        List<Course> coursesEnrolled=new ArrayList<>();

        for(EnrolledCourse enrolledCourse:enrolledCourses)
        {
            if(Objects.equals(enrolledCourse.getEmployee().getEmployeeId(), employeeId)){
                coursesEnrolled.add(enrolledCourse.getCourse());

            }
        }
        return coursesEnrolled;
    }
}