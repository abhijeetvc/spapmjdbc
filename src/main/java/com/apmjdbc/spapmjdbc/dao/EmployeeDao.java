package com.apmjdbc.spapmjdbc.dao;

import com.apmjdbc.spapmjdbc.model.Employee;
import com.apmjdbc.spapmjdbc.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class EmployeeDao implements Employeerepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeList() {
        String sql="Select * from employee";
        List<Employee> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Employee.class));
        return list;
    }

    @Override
    public String insertEmployee(Employee emp) {
        String sql="insert into employee values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{emp.getId(),emp.getName(),emp.getCity(),
                emp.getDepartment().getId()});
        return "Employee added";
    }

    @Override
    public Employee getEmployee(Integer id) {
        String sql="select * from employee where id=?";
        Employee emp= (Employee) jdbcTemplate.queryForObject(sql,
                new Object[]{id},new int[]{Types.INTEGER},
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String sql="update employee set city=? where id=?";
        jdbcTemplate.update(sql,new Object[]{employee.getCity(),employee.getId()});
        return "Employee updated";
    }
}
