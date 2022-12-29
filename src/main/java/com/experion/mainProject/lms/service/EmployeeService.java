package com.experion.mainProject.lms.service;


import com.experion.mainProject.lms.dao.EmployeeRepo;
import com.experion.mainProject.lms.entity.Employees;
import com.experion.mainProject.lms.helper.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo EmployeeRepo;

    public void save(MultipartFile file) {
//extract data from excel and save to database
        try {
            List<Employees> employees = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.EmployeeRepo.saveAll(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Employees> getAllEmployee() {
        return this.EmployeeRepo.findAll();
    }



}
