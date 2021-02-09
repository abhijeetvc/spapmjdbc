package com.apmjdbc.spapmjdbc.repository;

import com.apmjdbc.spapmjdbc.model.Employee;

import java.util.List;
import java.util.Map;

public interface Employeerepo {

    List<Employee> getEmployeeList();

    String insertEmployee(Employee emp);

    Employee getEmployee(Integer id);

    String updateEmployee(Employee employee);

    List<Map<String,Object>> getCombinedData();

}
