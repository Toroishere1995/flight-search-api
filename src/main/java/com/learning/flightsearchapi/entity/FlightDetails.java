package com.learning.flightsearchapi.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that maps with database. This Class Entity is used for FlightDetails
 * mapping with database.
 * 
 * @author ayushsaxena
 *
 */
@Entity
@Table(name = "flightstable")
public class FlightDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "FLIGHT_NO")
	private String flightNumber;
	@Column(name = "DEP_LOC")
	private String departureLocation;
	@Column(name = "ARR_LOC")
	private String arrivalLocation;
	@Column(name = "VALID_TILL")
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String lastDateOfFlight;
	@Column(name = "FLIGHT_TIME")
	private String flightTime;
	@Column(name = "FARE")
	private int fareOfFlight;
	@Column(name = "FLIGHT_DUR")
	private double flightDuration;
	@Column(name = "SEAT_AVAILABILITY")
	private String seatAvailability;
	@Column(name = "CLASS")
	private String flightClass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

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

	public LocalDate getLastDateOfFlight() {
		System.out.println("Get : " + lastDateOfFlight);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(lastDateOfFlight, formatter);
		System.out.println(localDate);
		return localDate;
	}

	public void setLastDateOfFlight(String lastDateOfFlight) {
		this.lastDateOfFlight = lastDateOfFlight;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public int getFareOfFlight() {
		return fareOfFlight;
	}

	public void setFareOfFlight(int fareOfFlight) {
		this.fareOfFlight = fareOfFlight;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

}
