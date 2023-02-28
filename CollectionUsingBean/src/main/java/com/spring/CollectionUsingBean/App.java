package com.spring.CollectionUsingBean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context=new ClassPathXmlApplicationContext("classpath:application.xml");
    	System.out.println("Context Created");
    	context.registerShutdownHook();
		if (context.containsBean("question1")) {
			QuestionAnswer question1 = (QuestionAnswer) context.getBean("question1");
			System.out.println(question1);
		} else {
			System.out.println("No Bean Found");
		}
    }
}
