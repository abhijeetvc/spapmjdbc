package com.apmjdbc.spapmjdbc.aop;

import com.apmjdbc.spapmjdbc.model.Employee;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

//    @After("execution (* com.apmjdbc.spapmjdbc.dao.EmployeeDao.getEmployeeList())")
//    public void checkAop(){
//        System.out.println("Aop execution done...");
//    }

    @AfterReturning(pointcut = "execution (* com.apmjdbc.spapmjdbc.dao.EmployeeDao.getEmployee(..))",
                    returning = "retValue")
    public void checkAop1(Object retValue){
        Employee emp= (Employee) retValue;
        System.out.println("Id: "+emp.getId());
        System.out.println("Name: "+emp.getName());
        System.out.println("City: "+emp.getCity());
    }
}
