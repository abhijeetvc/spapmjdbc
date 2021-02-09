package com.apmjdbc.spapmjdbc.dao;

import com.apmjdbc.spapmjdbc.model.Employee;
import com.apmjdbc.spapmjdbc.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao implements Employeerepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeList() {
        System.out.println("In get employee...");
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

    @Override
    public List<Map<String, Object>> getCombinedData() {
        String sql="select a.id,a.name,a.city,b.name as deptName from employee a,department b " +
                "where a.dept_id=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}
