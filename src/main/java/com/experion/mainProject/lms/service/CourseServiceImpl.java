package com.experion.mainProject.lms.service;

import com.experion.mainProject.lms.dao.CourseRepository;
import com.experion.mainProject.lms.dao.EnrolledCourseRepository;
import com.experion.mainProject.lms.dao.ModuleRepository;
import com.experion.mainProject.lms.dto.*;
import com.experion.mainProject.lms.entity.*;
import com.experion.mainProject.lms.entity.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class CourseServiceImpl implements CourseServices {
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
    public ResponseEntity addCourse(AddCourse addCourse) {


        Course course = addCourse.getCourse();
        if (course != null) {


            CourseCategory category = addCourse.getCategory();
            course.setCategory(category);
            if (courseRepository.save(course) != null) {
                return new ResponseEntity<>("Course added successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Course not added", HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Override
    public ResponseEntity addModule(AddModule addModule) {
        //retrive the module info from dto
        Module module = addModule.getModule();
        if (module != null) {
            module.setCourse(addModule.getCourse());

            //populate module with module resource
            Set<ModuleResource> moduleResourceItems = addModule.getModuleResourceItem();
            moduleResourceItems.forEach(item -> module.add(item));


            //save to database
            if (moduleRepository.save(module) != null) {
                return new ResponseEntity<>("Module added successfully!", HttpStatus.OK);
            }

        }
        return new ResponseEntity<>("Module not added", HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Override
    public void sendRejectMail(RejectMailRequest rejectMailRequest) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(message, StandardCharsets.UTF_8.toString());
        messageHelper.setSubject("L&D Team:Course Approval");
        messageHelper.setText("Hi " + rejectMailRequest.getEmployeeName() + ",\nWe regret to inform you that the course "
                + "'" + rejectMailRequest.getCourseName() + "'" + " that you have enrolled for has been rejected.\nReason for Rejection: " + rejectMailRequest.getRejectionReason() +
                "Please ensure to enroll for courses " +
                "that are relevant to your current domain\nThanks & Regards,\nL&D Team");
        messageHelper.setFrom("lmslearningapp@gmail.com");
        messageHelper.setTo(rejectMailRequest.getEmployeeEmail());
        mailSender.send(message);


    }

    @Override
    public void enrollCourse(AddEnrolledCourse addEnrolledCourse) {
        //to post newly enrolled course to database
        EnrolledCourse enrolledCourse = new EnrolledCourse();
        enrolledCourse.setEnrolledDate(addEnrolledCourse.getEnrolledDate());
        enrolledCourse.setEmployee(addEnrolledCourse.getEmployeeId());
        enrolledCourse.setCourse(addEnrolledCourse.getCourseId());
        enrolledCourseRepository.save(enrolledCourse);
    }


    @Override
    public ListEnrolledCourseResponse getEnrolledCourse(Long employeeId) {
    //to list courses enrolled by a particular employee
        List<EnrolledCourse> enrolledCourses = enrolledCourseRepository.findAll();
        List<Course> coursesEnrolled = new ArrayList<>();
        List<EnrolledCourse> enrolledCourseId=new ArrayList<>();

        for (EnrolledCourse enrolledCourse : enrolledCourses) {
            if (Objects.equals(enrolledCourse.getEmployee().getEmployeeId(), employeeId)) {
                coursesEnrolled.add(enrolledCourse.getCourse());
                enrolledCourseId.add(enrolledCourse);

            }
        }
        return new ListEnrolledCourseResponse(coursesEnrolled,enrolledCourseId);
    }
}
