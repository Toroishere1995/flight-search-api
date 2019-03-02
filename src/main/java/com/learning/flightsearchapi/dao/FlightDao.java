package com.learning.flightsearchapi.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.learning.flightsearchapi.dto.FlightConnectingResult;
import com.learning.flightsearchapi.dto.FlightDirectResult;
import com.learning.flightsearchapi.dto.FlightSearchEntity;
import com.learning.flightsearchapi.util.ConversionUtil;
import com.learning.flightsearchapi.util.HibernateUtil;

/**
 * Class which fetches Flight Entity from database and returns all flights
 * available. It also fetches connecting airlines if no direct flight is
 * available.
 * 
 * @author ayushsaxena
 *
 */
public class FlightDao {

	/**
	 * Method to return either direct flights or connecting flights.
	 * 
	 * @param entity
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Object> getFlights(FlightSearchEntity entity, int page, int size) {
		// TODO Auto-generated method stub
		System.out.println(entity.getDateOfFlight());
		int firstIndex = size * (page - 1);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery("select N1.flightNumber as flightNumber , " + "N1.flightTime as flightTime ,"
				+ "N1.fareOfFlight as fareOfFlight ," + "N1.flightDuration as flightDuration "
				+ "from FlightDetails as N1 where N1.departureLocation = :deploc " + "and N1.arrivalLocation = :arrloc "
				+ "and N1.flightClass = :class " + "and N1.lastDateOfFlight >= :date "
				+ " and N1.seatAvailability = 'Y' ");
		System.out.println(entity.getDepartureLocation() + " " + entity.getArrivalLocation() + " " + entity.getClass()
				+ " " + entity.getDateOfFlight());
		query.setParameter("deploc", entity.getDepartureLocation());
		query.setParameter("arrloc", entity.getArrivalLocation());
		query.setParameter("class", entity.getFlightClass());
		query.setDate("date", entity.getDateOfFlight());
		query.setFirstResult(firstIndex);
		query.setMaxResults(size);
		query.setResultTransformer(Transformers.aliasToBean(FlightDirectResult.class));

		List<Object> list = query.getResultList();
		// Incase a Flight exists between specified arrival and departure
		// location.
		if (list.size() != 0) {
			return list;
		}
		// If no direct flight exists look for connecting flight
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String datee=format.format(entity.getDateOfFlight());
		query = session.createQuery("select N1.flightNumber as flightSource ," + "N2.flightNumber as flightMid ,"
				+ "N1.fareOfFlight+N2.fareOfFlight as totalFare ,"
				+ "N1.flightDuration + N2.flightDuration as totalTime , " + "N1.flightTime as flightTimeAtSource ,"
				+ "N2.flightTime as flightTimeAtMid , N1.flightDuration as timeFromSource , N2.departureLocation as connectorLocation "
				+ " from FlightDetails as N1 " + "inner join FlightDetails as N2 "
				+ "on N1.arrivalLocation=N2.departureLocation "
				+ "where N1.departureLocation= :deploc and N2.arrivalLocation= :arrloc "
				+ " and N1.lastDateOfFlight >= :date "
				+ " and N1.flightClass = :class and N1.flightClass = N2.flightClass  "
				+ " and N1.seatAvailability = 'Y' and N2.seatAvailability = 'Y' "
				+ "and substring(N1.flightNumber,1,3) = substring(N2.flightNumber,1,3)"
				+ " and (datediff(N1.lastDateOfFlight,N2.lastDateOfFlight)between 0 and 1)");
		query.setParameter("deploc", entity.getDepartureLocation());
		query.setParameter("arrloc", entity.getArrivalLocation());
		query.setParameter("class", entity.getFlightClass());
		query.setParameter("date", datee);
		query.setFirstResult(firstIndex);
		query.setMaxResults(size);
		query.setResultTransformer(Transformers.aliasToBean(FlightConnectingResult.class));

		List<Object> listNew = query.getResultList();
		session.close();
		if (listNew.size() != 0) {
			return listNew;
		}
		// In case no connecting point is available.
		return new ArrayList<>();
	}

}
