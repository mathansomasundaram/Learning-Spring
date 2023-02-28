package com.spring.AutoWire;

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

    	AbstractApplicationContext context=new ClassPathXmlApplicationContext("classpath:application.xml");
    	context.registerShutdownHook();
    	User user=(User)context.getBean("user");
    	User user1=(User)context.getBean("user");

    	System.out.println(user.getUserName());
    	user.getComputer().compile();
    }
}
