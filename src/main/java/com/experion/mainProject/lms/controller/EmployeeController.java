package com.experion.mainProject.lms.controller;

import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.helper.Helper;
import com.experion.mainProject.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins="*")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("*/employee/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.employeeService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("*/employee/all")
    public List<Employees> getAllEmployee() {
        return this.employeeService.getAllEmployee();
    }


}
