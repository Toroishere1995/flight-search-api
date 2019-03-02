package com.learning.flightsearchapi.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import com.learning.flightsearchapi.dao.CurrencyDao;
import com.learning.flightsearchapi.dao.FlightDao;
import com.learning.flightsearchapi.dto.FlightConnectingResult;
import com.learning.flightsearchapi.dto.FlightDirectResult;
import com.learning.flightsearchapi.dto.FlightSearchEntity;
import com.learning.flightsearchapi.service.IFlightService;
import com.learning.flightsearchapi.service.ISortService;
import com.learning.flightsearchapi.util.ConversionUtil;

/**
 * Service Class that handles the major services of our api such as fetching
 * list, conversion of currency,sorting flights.
 * 
 * @author ayushsaxena
 *
 */
public class FlightService implements IFlightService {

	/**
	 * Method that converts fare of flight with the code provided.
	 */
	@Override
	public void convertRateToCurrencyRateSpecified(String currencyCode, List<Object> resultList) {
		// TODO Auto-generated method stub
		CurrencyDao currencyDao = new CurrencyDao();
		double currenyRate = currencyDao.fetchCurrencyRate(currencyCode);
		if (resultList == null || resultList.size() == 0) {
			return;
		}
		if (resultList.get(0) instanceof FlightConnectingResult) {
			List<FlightConnectingResult> list = (List<FlightConnectingResult>) (Object) resultList;
			list.forEach(new Consumer<FlightConnectingResult>() {

				@Override
				public void accept(FlightConnectingResult connectingResult) {
					connectingResult.setTotalFare(connectingResult.getTotalFare() * currenyRate);
				}
			});
		} else if (resultList.get(0) instanceof FlightDirectResult) {
			List<FlightDirectResult> list = (List<FlightDirectResult>) (Object) resultList;
			list.forEach(new Consumer<FlightDirectResult>() {

				@Override
				public void accept(FlightDirectResult directResult) {
					directResult.setFareOfFlight(directResult.getFareOfFlight() * currenyRate);
				}
			});
		}
	}

	/**
	 * Method that handles total duration for connecting flights.
	 * 
	 * @param resultList
	 */
	public void handleTotalDurationForConnectingFlights(List<Object> resultList) {
		// TODO Auto-generated method stub
		if (resultList == null || resultList.size() == 0) {
			return;
		}
		System.out.println(resultList.size());
		if (resultList.get(0) instanceof FlightConnectingResult) {
			List<FlightConnectingResult> list = (List<FlightConnectingResult>) (Object) resultList;
			list.forEach(new Consumer<FlightConnectingResult>() {

				@Override
				public void accept(FlightConnectingResult connectingResult) {
					// TODO Auto-generated method stub
					int check = ConversionUtil.convertToTimeAndAddDuration(connectingResult);
					if (check == 0) {
						list.remove(connectingResult);
					}
				}
			});
		}

	}

	/**
	 * Method that fetches result list for searched flights.
	 */
	@Override
	public List<Object> fetchResultList(FlightSearchEntity entity, int page, int size) {
		// TODO Auto-generated method stub
		FlightDao flightDao = new FlightDao();
		List<Object> flights = flightDao.getFlights(entity, page, size);
		handleTotalDurationForConnectingFlights(flights);

		return flights;
	}

	@Override
	public void sortFlights(List<Object> results, String sortType) {
		// TODO Auto-generated method stub
		ISortService sortService = null;
		switch (sortType) {
		case "cheapest":
			sortService = new SortCheapestService();

			break;

		case "fastest":
			sortService = new SortFastestService();
			break;

		}
		sortService.sortSearchedFlights(results);
	}

}
