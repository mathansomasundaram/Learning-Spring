package com.spring.autowiredannotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    	
    	User user=(User)context.getBean("user");
    	user.getComputer().compile();
    }
}
