package com.spring.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.spring.hibernate.configuration.HibernateConfig;
import com.spring.hibernate.model.CountryDetails;
public class App 
{
	private static final Logger logger = Logger.getLogger(App.class);  

    public static void main( String[] args )
    {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			CountryDetails c = new CountryDetails();
			c.setCountryCode("BT");
			c.setCountryName("Bhutan");
			c.setCountryRegion("South Asia");
			/* To Save record */
			session.persist(c);
			session.getTransaction().commit();

			/* To Retrieve record using PrimaryKey */
			CountryDetails result = session.get(CountryDetails.class, "IND");
			logger.info("Country Details-->" + result);

			/* To Retrieve record using HQL */
			Query<CountryDetails> query = session.createQuery("from CountryDetails where upper(CountryName) like :name");
			query.setParameter("name", "India".toUpperCase());
			CountryDetails c1 = query.uniqueResult();
			logger.info("Country Details of India"+c1);
			
			Query<CountryDetails> queryCountry=session.createQuery("from CountryDetails where upper(CountryRegion)=:countryRegion");
			queryCountry.setParameter("countryRegion", "Northern Africa".toUpperCase());
			List<CountryDetails> listofCountries=queryCountry.getResultList();
			
			logger.info("Northern Africa Countries:");
			for(CountryDetails country:listofCountries) {
				logger.info(country.getCountryName());
			}
			
			HibernateConfig.shutdown();
		}catch(Exception e) {
    		logger.error("Exception Occured");
    	}

    	
    }
}
