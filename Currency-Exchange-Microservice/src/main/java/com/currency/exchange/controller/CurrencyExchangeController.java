package com.currency.exchange.controller;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.configuration.ConfigurationForProperties;
import com.currency.exchange.entity.CurrencyExchange;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;

	@Autowired
	private ConfigurationForProperties configurationForProperties;
	
	@GetMapping("/currencyExchange/demo")
	public Map<String, Integer> demo(){
		Map<String, Integer> map =  new LinkedHashMap<String, Integer>();
		map.put("Minimum" , configurationForProperties.getMinimum());
		map.put("Maximum" , configurationForProperties.getMaximum());
		
		return map;
	}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		CurrencyExchange currencyExchange= CurrencyExchange.builder().id(1000L).from(from).to(to).conversionMultiple(BigDecimal.valueOf(50)).build();
		currencyExchange.setEnvironment( environment.getProperty("local.server.port"));
		
		return currencyExchange;
	}
}
