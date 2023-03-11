package com.spring.hibernate;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.spring.hibernate.configuration.HibernateConfig;
import com.spring.hibernate.model.Customer;
import com.spring.hibernate.model.Orders;

public class App 
{
	public static final Logger logger=Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {

    	SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
    	try(Session session=HibernateConfig.getSessionFactory().openSession()){
    		
    		Customer c1=new Customer();
    		c1.setCustomerId(101);
    		c1.setCustomerName("Mathan");
    		c1.setCustomerEmailId("mathan@gmail.com");
    		
    		Orders order1=new Orders();
			order1.setPurchaseDate(simpleDateFormat.parse("11/11/2022"));
    		order1.setTotalAmount(100);
    		order1.setProductName("T-Shirt");
    		order1.setCustomer(c1);
    		
    		Orders order2=new Orders();
    		order2.setPurchaseDate(simpleDateFormat.parse("11/09/2022"));
    		order2.setTotalAmount(50);
    		order2.setProductName("Pant");
    		order2.setCustomer(c1);
    		
    		session.beginTransaction();
    		c1.getOrders().add(order1);
    		c1.getOrders().add(order2);
    		session.saveOrUpdate(c1);
    		session.saveOrUpdate(order2);
    		session.saveOrUpdate(order1);
    		session.getTransaction().commit();
    	}catch(Exception e) {
    		logger.error(e);	
    	}finally {
    		HibernateConfig.shutdown();
    	}
    }
}
