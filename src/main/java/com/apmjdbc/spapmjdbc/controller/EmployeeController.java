package com.apmjdbc.spapmjdbc.controller;

import com.apmjdbc.spapmjdbc.dao.EmployeeDao;
import com.apmjdbc.spapmjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/getemployee")
    public List<Employee> getData(){
        return employeeDao.getEmployeeList();
    }

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee emp){
        return employeeDao.insertEmployee(emp);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeDao.getEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){

        return employeeDao.updateEmployee(employee);
    }

    @GetMapping("/joindata")
    public List<Map<String,Object>> getJoinData(){
        return employeeDao.getCombinedData();
    }

}
