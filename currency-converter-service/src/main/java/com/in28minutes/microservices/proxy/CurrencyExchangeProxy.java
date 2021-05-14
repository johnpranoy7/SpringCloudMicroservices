package com.in28minutes.microservices.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.bean.CurrencyConverterTemplate;


//@FeignClient(name = "currency-exchange-service", url="localhost:8000")    
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	//Appended this apps name in front to get localhost:8765/{app name}/{uri}
	@GetMapping("/currency-exchange-service/currency-exchange/{from}/to/{to}")
	public CurrencyConverterTemplate getExchangeRateBean(@PathVariable("from") String from, @PathVariable("to") String to);
	
	
//	@GetMapping("/currency-exchange/{from}/to/{to}")
//	public CurrencyConverterTemplate getExchangeRateBean(@PathVariable("from") String from, @PathVariable("to") String to);
}
