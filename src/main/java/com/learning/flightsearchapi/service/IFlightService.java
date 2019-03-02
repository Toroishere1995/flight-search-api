package com.learning.flightsearchapi.service;

import java.util.List;

import com.learning.flightsearchapi.dto.FlightSearchEntity;

/**
 * Interface that is used for Flight Services.
 * 
 * @author ayushsaxena
 *
 */
public interface IFlightService {
	/**
	 * Method to Implemented in order to fetch Flights.
	 * 
	 * @param entity
	 * @param page
	 * @param size
	 * @return
	 */
	List<Object> fetchResultList(FlightSearchEntity entity, int page, int size);

	/**
	 * Method to implemented in order to convert currency.
	 * 
	 * @param currencyCode
	 * @param resultList
	 */
	void convertRateToCurrencyRateSpecified(String currencyCode, List<Object> resultList);

	/**
	 * Method to implement in order to sort flights.
	 * 
	 * @param results
	 * @param sortType
	 */
	void sortFlights(List<Object> results, String sortType);
}
