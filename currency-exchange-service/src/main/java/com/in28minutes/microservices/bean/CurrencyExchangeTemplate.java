package com.in28minutes.microservices.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchangeTemplate {
	
	@Id
	private long id;
	@Column(name = "exchange_from")
	private String from;
	@Column(name = "exchange_to")
	private String to;
	private Double rate;
	private int port; // To View which port is being used. Not good practise in Prod. Only for
						// Learning

	public CurrencyExchangeTemplate() {

	}

	public CurrencyExchangeTemplate(long id, String from, String to, Double rate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyExchangeTemplate [id=" + id + ", from=" + from + ", to=" + to + ", rate=" + rate + "]";
	}

}
