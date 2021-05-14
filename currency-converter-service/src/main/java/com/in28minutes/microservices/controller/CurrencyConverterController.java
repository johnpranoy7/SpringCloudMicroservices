package com.in28minutes.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservices.bean.CurrencyConverterTemplate;
import com.in28minutes.microservices.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConverterController {

	@Autowired
	Environment environment;

	@Autowired
	CurrencyExchangeProxy proxy;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterTemplate getCurrencyConv(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") double quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConverterTemplate> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConverterTemplate.class,
				uriVariables);
		System.out.println("ResponseEntity: " + responseEntity);
		CurrencyConverterTemplate body = responseEntity.getBody();
		System.out.println("Body:" + body);
		CurrencyConverterTemplate currencyConverterTemplate = new CurrencyConverterTemplate(body.getId(), from, to,
				body.getRate(), quantity, quantity * body.getRate());
		currencyConverterTemplate.setPort(body.getPort());
		logger.info("{}", currencyConverterTemplate);
		return currencyConverterTemplate;
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConverterTemplate getCurrencyConvFeign(@PathVariable("from") String from,
			@PathVariable("to") String to, @PathVariable("quantity") double quantity) {

		CurrencyConverterTemplate response = proxy.getExchangeRateBean(from, to);
		System.out.println("Response Feint: " + response);
		CurrencyConverterTemplate currencyConverterTemplate = new CurrencyConverterTemplate(response.getId(), from, to,
				response.getRate(), quantity, quantity * response.getRate());
		currencyConverterTemplate.setPort(response.getPort());
		logger.info("{}", currencyConverterTemplate);
		return currencyConverterTemplate;
	}
}
