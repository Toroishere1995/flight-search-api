package com.learning.flightsearchapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * POJO class that holds flight details of Connecting flights.
 * 
 * @author ayushsaxena
 *
 */
public class FlightConnectingResult {

	private String flightSource;
	private String flightMid;
	private double totalFare;
	private double totalTime;
	private String flightTimeAtSource;
	private String flightTimeAtMid;
	@JsonIgnore
	private double timeFromSource;
	private String connectorLocation;

	public String getFlightTimeAtSource() {
		return flightTimeAtSource;
	}

	public void setFlightTimeAtSource(String flightTimeAtSource) {
		this.flightTimeAtSource = flightTimeAtSource;
	}

	public String getFlightTimeAtMid() {
		return flightTimeAtMid;
	}

	public void setFlightTimeAtMid(String flightTimeAtMid) {
		this.flightTimeAtMid = flightTimeAtMid;
	}

	public FlightConnectingResult() {
		// TODO Auto-generated constructor stub
	}

	public FlightConnectingResult(String flightSource, String flightMid, int totalFare, double totalTime,
			String flightTimeAtSource, String flightTimeAtMid, double timeFromSource, String connectorLocation) {
		this.flightSource = flightSource;
		this.flightMid = flightMid;
		this.totalFare = totalFare;
		this.totalTime = totalTime;
		this.flightTimeAtSource = flightTimeAtSource;
		this.flightTimeAtMid = flightTimeAtMid;
		this.timeFromSource = timeFromSource;
		this.connectorLocation = connectorLocation;
	}

	public String getFlightSource() {
		return flightSource;
	}

	public void setFlightSource(String flightSource) {
		this.flightSource = flightSource;
	}

	public String getFlightMid() {
		return flightMid;
	}

	public void setFlightMid(String flightMid) {
		this.flightMid = flightMid;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public double getTimeFromSource() {
		return timeFromSource;
	}

	public void setTimeFromSource(double timeFromSource) {
		this.timeFromSource = timeFromSource;
	}

	public String getConnectorLocation() {
		return connectorLocation;
	}

	public void setConnectorLocation(String connectorLocation) {
		this.connectorLocation = connectorLocation;
	}

}
