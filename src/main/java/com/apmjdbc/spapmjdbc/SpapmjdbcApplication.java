package com.apmjdbc.spapmjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpapmjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpapmjdbcApplication.class, args);
	}

}

// Aspect Oriented Programming(AOP)

// Aspect:  It is a cross cutting-concern
// PointCut: Scenario that matches the joinpoint
// JoinPoint: It represents the execution of method
// Advice: Action taken by the aspect (After, Before, Around, AfterReturning, AfterThrowing)