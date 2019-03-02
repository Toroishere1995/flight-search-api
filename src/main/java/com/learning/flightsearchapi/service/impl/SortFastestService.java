package com.learning.flightsearchapi.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.learning.flightsearchapi.dto.FlightConnectingResult;
import com.learning.flightsearchapi.dto.FlightDirectResult;
import com.learning.flightsearchapi.service.ISortService;

/**
 * Class that sort according to duration of flight with fastest at the top.
 * @author ayushsaxena
 *
 */
public class SortFastestService implements ISortService {

	/**
	 * Method implemented to sort with respect to duration of flight.
	 */
	@Override
	public void sortSearchedFlights(List<Object> flights) {
		// TODO Auto-generated method stub
		if (flights == null || flights.size() == 0) {
			return;
		}
		if (flights.get(0) instanceof FlightDirectResult) {
			List<FlightDirectResult> convertedList = (List<FlightDirectResult>) (Object) flights;
			Collections.sort(convertedList, Comparator.comparingDouble(FlightDirectResult::getFlightDuration));
		} else if (flights.get(0) instanceof FlightConnectingResult) {
			List<FlightConnectingResult> convertedList = (List<FlightConnectingResult>) (Object) flights;
			Collections.sort(convertedList, Comparator.comparingDouble(FlightConnectingResult::getTotalTime));
		}
	}

}
