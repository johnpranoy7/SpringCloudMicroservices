package com.in28min.microservices.bean;

public class LimitsConfiguration {

	private int maximum;
	private int minimum;

	public LimitsConfiguration() {

	}

	public LimitsConfiguration(int max, int min) {
		this.maximum = max;
		this.minimum = min;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

}
