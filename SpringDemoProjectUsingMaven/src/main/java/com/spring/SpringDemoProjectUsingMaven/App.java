package com.spring.SpringDemoProjectUsingMaven;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.spring.POJO.EmployeeDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	ApplicationContext factory = new ClassPathXmlApplicationContext("application.xml");
    	
        
        EmployeeDetails emp=(EmployeeDetails)factory.getBean("Employee");
        emp.display();
        System.out.println(emp.getSalary());
        
    }
}
