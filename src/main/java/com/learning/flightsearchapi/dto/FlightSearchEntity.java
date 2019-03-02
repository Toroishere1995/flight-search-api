package com.learning.flightsearchapi.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class FlightSearchEntity {

	private String departureLocation;
	private String arrivalLocation;
	private String dateOfFlight;
	private String flightClass;

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getDateOfFlight() {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(dateOfFlight);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public void setDateOfFlight(String dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

}
