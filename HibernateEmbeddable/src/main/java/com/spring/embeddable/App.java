package com.spring.embeddable;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.spring.embeddable.model.Address;
import com.spring.embeddable.model.UserDetails;
import com.spring.hibernate.configuration.HibernateConfig;

public class App 
{
	private static final Logger logger = Logger.getLogger(App.class);  

    public static void main( String[] args )
    {

    	try(Session session=HibernateConfig.getSessionFactory().openSession()){
    		Address address=new Address();
    		address.setStreet("Beach road");
    		address.setCity("Kovai");
    		address.setPincode(64115);
    		
    		
    		Address address1=new Address();
    		address1.setStreet("PN Puthur");
    		address1.setCity("Trichy");
    		address1.setPincode(6410);
    		UserDetails user=new UserDetails();
    		user.setUsername("Mohan");
    		user.getAddress().add(address);
    		user.getAddress().add(address1);

    		/*
    		session.beginTransaction();
    		logger.info(user);
    		session.save(user);
    		session.getTransaction().commit();
    		*/
    		
    		/*Lazy or Eager Fetch*/
    		user=session.get(UserDetails.class, 1);
    		session.close();
    		System.out.println(user);
    		
    	}catch(Exception e) {
    		logger.info("Exception"+e);
    	}
    }
}
