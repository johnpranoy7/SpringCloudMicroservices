package com.in28minutes.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.microservices.bean.CurrencyExchangeTemplate;

public interface ExchangeServiceRepo extends JpaRepository<CurrencyExchangeTemplate, Integer> {

	CurrencyExchangeTemplate findByFromAndTo(String from, String to);

}
