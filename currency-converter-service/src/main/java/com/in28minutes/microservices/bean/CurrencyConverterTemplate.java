package com.in28minutes.microservices.bean;

public class CurrencyConverterTemplate {
	private int id;
	private String from;
	private String to;
	private double rate;
	private double quantity;
	private double totalAmount;
	private int port;

	public CurrencyConverterTemplate() {

	}

	public CurrencyConverterTemplate(int id, String from, String to, double rate, double quantity, double totalAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConverterTemplate [id=" + id + ", from=" + from + ", to=" + to + ", rate=" + rate
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount + ", port=" + port + "]";
	}

}
