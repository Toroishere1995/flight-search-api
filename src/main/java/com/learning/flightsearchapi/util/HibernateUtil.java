package com.learning.flightsearchapi.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Class that returns SessionFactory.It is a utility class for Hibernate.
 * 
 * @author ayushsaxena
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	/**
	 * Static block.
	 */
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Method to give instance of session factory.
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
