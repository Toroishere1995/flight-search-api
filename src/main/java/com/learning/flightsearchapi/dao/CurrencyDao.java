package com.learning.flightsearchapi.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import com.learning.flightsearchapi.entity.CurrencyRates;
import com.learning.flightsearchapi.util.HibernateUtil;

/**
 * Class that fetches rate for currency change as per requested by user.
 * 
 * @author ayushsaxena
 *
 */
public class CurrencyDao {

	/**
	 * Method that fetches CurrencyRate object from database and return currency
	 * rate.
	 * 
	 * @param currencyCode
	 * @return
	 */
	public double fetchCurrencyRate(String currencyCode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hqlQuery = "from CurrencyRates c where c.currencyCode = :code";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("code", currencyCode);
		CurrencyRates currency = (CurrencyRates) query.getSingleResult();
		if (currency == null) {
			return 1.0;
		}
		return currency.getCurrencyRate();
	}
}
