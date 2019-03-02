package com.learning.flightsearchapi.service;

import java.util.List;

/**
 * Interface to sort list of flights.
 * 
 * @author ayushsaxena
 *
 */
public interface ISortService {
	/**
	 * Method to be implemented to sort searched flights.
	 * 
	 * @param fligts
	 */
	void sortSearchedFlights(List<Object> fligts);
}
