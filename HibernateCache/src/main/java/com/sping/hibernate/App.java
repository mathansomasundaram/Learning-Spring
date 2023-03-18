package com.sping.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sping.hibernate.model.CountryDetails;
import com.spring.Hibernate.Configuraiton.HibernateConfig;

public class App 
{
    public static void main( String[] args )
    {
        try(Session session=HibernateConfig.getSessionFactory().openSession()){
        	session.beginTransaction();
        	
//        	CountryDetails country=session.get(CountryDetails.class, "IND");
//        	System.out.println(country);

        	TypedQuery query=session.getNamedQuery("findAllDetails");
        	
        	List<CountryDetails> list=query.getResultList();
        	for(CountryDetails c:list) {
        		System.out.println(c.getCountryName());
        	}
        	session.getTransaction().commit();
        	
        	Session session1=HibernateConfig.getSessionFactory().openSession();
        	session1.beginTransaction();
        	
//        	CountryDetails country1=session1.get(CountryDetails.class, "IND");
//        	System.out.println(country1);

        	TypedQuery query1=session.getNamedQuery("findAllDetails");
        	List<CountryDetails> list1=query.getResultList();
        	for(CountryDetails c:list1) {
        		System.out.println(c.getCountryName());
        	}
        	session1.getTransaction().commit();
        }
    }
}
