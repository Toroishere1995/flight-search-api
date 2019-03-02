package com.learning.flightsearchapi.dto;

/**
 * POJO class that holds details of Direct Flight.
 * 
 * @author ayushsaxena
 *
 */
public class FlightDirectResult {
	private String flightNumber;
	private String flightTime;
	private double fareOfFlight;
	private double flightDuration;

	public FlightDirectResult() {
		// TODO Auto-generated constructor stub
	}

	public FlightDirectResult(String flightNumber, String flightTime, int fareOfFlight, double flightDuration) {
		// TODO Auto-generated constructor stub
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.fareOfFlight = fareOfFlight;
		this.flightDuration = flightDuration;

	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public double getFareOfFlight() {
		return fareOfFlight;
	}

	public void setFareOfFlight(double fareOfFlight) {
		this.fareOfFlight = fareOfFlight;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}

}
