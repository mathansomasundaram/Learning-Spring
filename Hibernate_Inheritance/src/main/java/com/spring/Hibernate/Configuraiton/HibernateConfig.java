package com.spring.Hibernate.Configuraiton;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	public static final SessionFactory sessionFactory=buildSessionFactory();
//	public static final Logger logger=Logger.getLogger(HibernateConfig.class);
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}catch(Exception e) {
//			logger.error("Exception :"+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		getSessionFactory().close();
	}
}
