package com.in28minutes.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.ExchangeServiceRepo;
import com.in28minutes.microservices.bean.CurrencyExchangeTemplate;

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment environment;

	@Autowired
	ExchangeServiceRepo exchangeServiceRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-exchange/{from}/to/{to}")
	public CurrencyExchangeTemplate getRate(@PathVariable("from") String from, @PathVariable("to") String to) {

		CurrencyExchangeTemplate currencyExchange = exchangeServiceRepo.findByFromAndTo(from, to);
		if (currencyExchange != null) {
			currencyExchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			logger.info("{}",currencyExchange);
			return currencyExchange;
		}
		return null;
	}
}
