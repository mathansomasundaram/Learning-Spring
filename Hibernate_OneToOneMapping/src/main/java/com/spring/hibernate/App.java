package com.spring.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.spring.hibernate.configuration.HibernateConfig;
import com.spring.hibernate.model.Employee;
import com.spring.hibernate.model.Vehicle;


public class App 
{
	private static final Logger logger=Logger.getLogger(App.class);
    public static void main( String[] args )
    {

    	try(Session session=HibernateConfig.getSessionFactory().openSession()){
    		
    		Vehicle v=new Vehicle();
    		v.setVehicleType("Bike");
    		v.setVehicleNumber("9347");
    		Employee e=new Employee();
    		e.setEmpName("Mohan");
    		e.setEmpVehicle(v);
    		
    		session.beginTransaction();
    		session.persist(e);
    		session.persist(v);
    		session.getTransaction().commit();
    	}catch(Exception e) {
    		logger.error(e);
    	}
    }
}
