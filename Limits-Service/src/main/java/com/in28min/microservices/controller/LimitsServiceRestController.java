package com.in28min.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.bean.Configuration;
import com.in28min.microservices.bean.LimitsConfiguration;

@RestController
public class LimitsServiceRestController {

	@Autowired
	Configuration config;

	@GetMapping("/limits")
	public LimitsConfiguration showLimits() {
		return new LimitsConfiguration(config.getMaximum(), config.getMinimum());
	}
}
