package com.learning.flightsearchapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that maps with database. This Class Entity is used for CurrencyRate
 * mapping with database.
 * 
 * @author ayushsaxena
 *
 */
@Entity
@Table(name = "currencyrates")
public class CurrencyRates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURRENCY_ID")
	private int id;
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	@Column(name = "CURRENCY_RATE")
	private double currencyRate;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public int getId() {
		return id;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	public void setId(int id) {
		this.id = id;
	}
}
