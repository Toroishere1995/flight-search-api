package com.learning.flightsearchapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.learning.flightsearchapi.dto.FlightSearchEntity;
import com.learning.flightsearchapi.service.IFlightService;
import com.learning.flightsearchapi.service.impl.FlightService;

/**
 * Class handles the request for API
 * 
 * @author ayushsaxena
 *
 */
@Path("flightservice")
public class FlightSearchRestService {

	/**
	 * Method that consumes JSON for Flight Search Entity and returns result of
	 * flights.
	 * 
	 * @param page
	 * @param size
	 * @param sortType
	 * @param currencyCode
	 * @param entity
	 * @return
	 */
	@POST
	@Path("/getFlights")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Object> getFlightResult(@DefaultValue("1") @QueryParam("page") int page,
			@DefaultValue("3") @QueryParam("size") int size,
			@DefaultValue("cheapest") @QueryParam("sortType") String sortType,
			@HeaderParam("X-Currency") String currencyCode, FlightSearchEntity entity) {

		IFlightService flightService = new FlightService();
		List<Object> results = flightService.fetchResultList(entity, page, size);
		flightService.convertRateToCurrencyRateSpecified(currencyCode, results);
		flightService.sortFlights(results, sortType);
		return results;

	}

	
}
