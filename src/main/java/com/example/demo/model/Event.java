package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String buyerParty;
	private String sellerParty;
	private double premiumAmount;
	private String premiumCurrency;

	public Event() {
	}

	public Event(String buyerParty, String sellerParty, double premiumAmount, String premiumCurrency) {
		this.buyerParty = buyerParty;
		this.sellerParty = sellerParty;
		this.premiumAmount = premiumAmount;
		this.premiumCurrency = premiumCurrency;
	}

	public String getBuyerParty() {
		return buyerParty;
	}

	public void setBuyerParty(String buyerParty) {
		this.buyerParty = buyerParty;
	}

	public String getSellerParty() {
		return sellerParty;
	}

	public void setSellerParty(String sellerParty) {
		this.sellerParty = sellerParty;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getPremiumCurrency() {
		return premiumCurrency;
	}

	public void setPremiumCurrency(String premiumCurrency) {
		this.premiumCurrency = premiumCurrency;
	}

}
