package com.apmjdbc.spapmjdbc.controller;

import com.apmjdbc.spapmjdbc.dao.EmployeeDao;
import com.apmjdbc.spapmjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getemployee")
    public List<Employee> getData(){
        return employeeDao.getEmployeeList();
    }
}
