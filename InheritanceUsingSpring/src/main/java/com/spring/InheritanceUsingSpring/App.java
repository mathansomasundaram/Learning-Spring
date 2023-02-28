package com.spring.InheritanceUsingSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Shapes.Rectangle;
import com.spring.Shapes.Triangle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
    	
    	if(context.containsBean("Triangle")) {
    		Triangle triangle=(Triangle)context.getBean("Triangle");
    		System.out.println("Area of triangle:"+triangle.calculateArea());
    	}
    	
    	if(context.containsBean("Rectangle")) {
    		Rectangle rectangle=(Rectangle)context.getBean("Rectangle");
    		System.out.println("Area of rectangle:"+rectangle.calculateArea());

    	}
    }
}
