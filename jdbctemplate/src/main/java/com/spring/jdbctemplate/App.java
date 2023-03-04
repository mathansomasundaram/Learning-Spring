package com.spring.jdbctemplate;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbctemplate.dao.EmployeeDao;
import com.spring.jdbctemplate.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	AbstractApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
    	context.registerShutdownHook();
    	
    	Employee employee=(Employee)context.getBean("employee");
    	
    	System.out.println(employee);
    	
    	EmployeeDao employeedao=(EmployeeDao)context.getBean("employeedao");
    	System.out.println(employeedao.insertEmployeeUsingNamedParameter(employee));
//    	List<Employee> e=employeedao.findAllEmployees();
    }
}
